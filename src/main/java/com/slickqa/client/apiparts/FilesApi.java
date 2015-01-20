package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.StoredFile;

/**
 * Api defining retrieving, updating and Deleting the files in slick.
 *
 * Also look at {@link com.slickqa.client.apiparts.FilesQueryApi}.
 *
 * @author Created by Jason Corbett on 4/17/14.
 */
public interface FilesApi {

    /**
     * Retrieve a specific stored file (not the content) based on the id.
     *
     * @return The stored file from slick.
     * @throws SlickError if an error occurs talking to slick.
     */
    StoredFile get() throws SlickError;

    /**
     * Add a "chunk" of data to a stored file.  This will cause slick to update the length of the file.  The size
     * of the chunk of data to upload is important.  You should use the default chunk size (which will be set
     * when the stored file was created).  It will almost always be 262144 in length.  The only reason to upload
     * a chunk of a different size is if this is the last chunk, and there isn't that much data left to upload.
     *
     * @param data The "chunk" of data to upload
     * @return The uploaded StoredFile
     * @throws SlickError if an error occurs talking to slick.
     */
    StoredFile addChunk(byte[] data) throws SlickError;

    /**
     * Update the metadata of a stored file in slick.  Warning, use this with caution.  You should not change the
     * chunk size, or the id.  The length of the file will be set when you add chunks to the file.  The only thing
     * you should update is the mime type, the name, or the md5sum.
     *
     * @param storedFile The updates to the stored file.
     * @return The updated stored file from slick.
     * @throws SlickError if an error occurs talking to slick.
     */
    StoredFile update(StoredFile storedFile) throws SlickError;
}
