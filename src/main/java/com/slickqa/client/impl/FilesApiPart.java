package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.FilesApi;
import com.slickqa.client.apiparts.FilesQueryApi;
import com.slickqa.client.errors.SlickCommunicationError;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.StoredFile;
import org.apache.tika.Tika;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by jcorbett on 1/17/15.
 */
public class FilesApiPart extends ApiPart<StoredFile> implements FilesQueryApi, FilesApi {
    private Tika tika;

    public FilesApiPart(ParentApiPart parent) {
        super(StoredFile.class, parent);
        tika = new Tika();
    }

    public FilesApiPart(ParentApiPart parent, ObjectMapper mapper) {
        super(StoredFile.class, parent, mapper);
        tika = new Tika();
    }

    @Override
    public StoredFile createAndUpload(Path localPath) throws SlickError {
        if(localPath == null) {
            throw new SlickError("Invalid use of createAndUpload, local path must not be null.");
        }

        if(!Files.isReadable(localPath)) {
            throw new SlickError(String.format("File at path {0} is not readable", localPath));
        }

        InputStream filestream;

        try {
            filestream = Files.newInputStream(localPath, StandardOpenOption.READ);
        } catch (IOException e) {
            throw new SlickError(String.format("Problem occured opening file {0} for reading.", localPath), e);
        }
        String mimetype = "application/octet-stream";
        try {
            mimetype = tika.detect(localPath.toFile());
        } catch (IOException e) {
            //TODO: log exception
        }

        return createAndUpload(localPath.getFileName().toString(), mimetype, filestream);
    }

    @Override
    public StoredFile createAndUpload(String filename, String mimetype, InputStream stream) throws SlickError {
        StoredFile storedFile = new StoredFile();
        storedFile.setFilename(filename);
        storedFile.setMimetype(mimetype);
        storedFile.setUploadDate(new Date());
        storedFile = create(storedFile);

        if(storedFile.getChunkSize() == null || storedFile.getChunkSize() <= 0) {
            storedFile.setChunkSize(262144); // 256k size chunks by default.  The server *should* always set this
        }

        try {
            byte[] buffer = new byte[storedFile.getChunkSize()];
            int last_read;
            do {
                last_read = stream.read(buffer, 0, storedFile.getChunkSize());
                // we have to get the slick client because we have to have SlickClientImpl
                storedFile =  getSlickClient().file(storedFile.getId()).addChunk(buffer);
            } while (last_read == storedFile.getChunkSize());
        } catch (IOException e) {
            throw new SlickError(MessageFormat.format("Error reading from {0}", filename), e);
        }
        return storedFile;
    }

    @Override
    public StoredFile addChunk(byte[] data) throws SlickError {
        // we can't use makeRequest because it does JSON, and we need binary here, so this is copied code
        WebTarget target = getWebTargetForRequest().path("addchunk");
        Response lastResponse = null;
        Exception lastException = null;
        for(int i = 0; i < 3; i++) {
            lastResponse = target.request().method("POST", Entity.entity(data, MediaType.APPLICATION_OCTET_STREAM));
            if (lastResponse.getStatus() == 200) {
                try {
                    return mapper.readValue(lastResponse.readEntity(String.class), type);
                } catch (IOException e) {
                    lastException = e;
                }
            }
        }
        if(lastException != null)
            throw new SlickCommunicationError(target.getUri().toString(), lastResponse, lastException);
        else
            throw new SlickCommunicationError(target.getUri().toString(), lastResponse);
    }


}
