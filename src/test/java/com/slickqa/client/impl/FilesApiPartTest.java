package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.FilesApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.StoredFile;
import mockit.Expectations;
import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests for ResultApiPart
 * Created by jcorbett on 4/16/14.
 */
@RunWith(JMockit.class)
public class FilesApiPartTest {
    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget webTarget;

    @Injectable
    WebTarget secondTarget;

    @Injectable
    WebTarget thirdTarget;

    @Injectable
    ObjectMapper mapper;

    @Injectable
    Invocation.Builder builder;

    @Injectable
    Response response;

    @Injectable
    SlickClient slickClient;

    @Injectable
    FilesApi filesApi;

    @Tested
    FilesApiPart filesApiPart;

    String jsonResponseString = "{}";

    JavaType storedFileType;


    @Before
    public void setUp() {
        final ObjectMapper realMapper = JsonUtil.getObjectMapper();
        storedFileType = realMapper.constructType(StoredFile.class);
        new NonStrictExpectations() {{
            mapper.getTypeFactory();
            result = realMapper.getTypeFactory();

            mapper.constructType(StoredFile.class);
            result = storedFileType;

            parent.getSlickClient();
            result = slickClient;
        }};

    }

    @Test(expected = SlickError.class)
    public void pathThatDoesntExistCausesError() throws Exception {
        filesApiPart.createAndUpload(Paths.get("/doesNotExist"));
    }

    @Test(expected = SlickError.class)
    public void nullPathCausesSlickError() throws Exception {
        filesApiPart.createAndUpload(null);
    }

    @Test
    public void createNewFileAndUpload() throws Exception {
        Path fileToUpload = Files.createTempFile("unittest", ".txt");
        fileToUpload.toFile().deleteOnExit();

        BufferedWriter writer = Files.newBufferedWriter(fileToUpload, Charset.defaultCharset());
        writer.write("Create New File And Upload Unit Test\n");
        writer.close();

        final String id = "createNewFileAndUploadId";
        final String filename = fileToUpload.getFileName().toString();
        final StoredFile expectedResult = new StoredFile();
        expectedResult.setId(id);
        expectedResult.setFilename(filename);
        expectedResult.setChunkSize(1024);
        final String updateJson = "foo";
        final List<StoredFile> created = new ArrayList<>();
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withCapture(created));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(storedFileType));
            result = expectedResult;

            slickClient.file(withEqual(id));
            result = filesApi;

            filesApi.addChunk(withAny(new byte[]{}));
            result = expectedResult;
        }};

        StoredFile retval = filesApiPart.createAndUpload(fileToUpload);
        assertThat(retval).named("createAndUpload return value").isNotNull();
        assertThat(retval).isSameAs(expectedResult);
        assertThat(created).isNotEmpty();
        assertThat(created).hasSize(1);
        assertThat(created.get(0).getFilename()).named("getFilename()").comparesEqualTo(fileToUpload.getFileName().toString());
        assertThat(created.get(0).getMimetype()).named("getMimetype()").comparesEqualTo("text/plain");
        assertThat(created.get(0).getUploadDate()).named("getUploadDate()").isNotNull();
    }


}
