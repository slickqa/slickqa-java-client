package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.StoredFile;

import java.io.InputStream;
import java.nio.file.Path;

/**
 * The file api has no generic query api.  You can't just query the files stored in slick, you can only find
 * files as references in other objects (such as {@link com.slickqa.client.model.Result},
 * {@link com.slickqa.client.model.Testrun}).  This file lets you create the stored files (<b>which you must do
 * before using them in the other objects</b>).
 *
 * This api also has some convenience methods for creating and uploading the file all at once.  Strictly speaking
 * you don't have to do it this way, but it is recommended.
 *
 * The one field that is somewhat critical, is the mime type field of {@link com.slickqa.client.model.StoredFile}.
 * That file tells slick what kind of file you are using.  So if you use the
 * {@link #create(com.slickqa.client.model.StoredFile)} method, make sure you include the mime type.  You can
 * use {@link java.nio.file.Files#probeContentType(java.nio.file.Path)}.
 *
 * <h3>Example: Uploading a file</h3>
 * <pre class="brush:java">
 *     SlickClient slick = SlickClientFactory.getSlickClient("http://localhost/slick/api");
 *     StoredFile movie = slick.files().createAndUpload(Paths.get("results", "testMovie.mp4"));
 *     System.out.println(MessageFormat.format("You can download the movie at http://localhost/slick/api/files/{0}/content/{1}", movie.getId(), movie.getFileName()));
 * </pre>
 *
 * @author Created by Jason Corbett on 4/17/14.
 */
public interface FilesQueryApi {

    /**
     * Create a new StoredFile in slick.  If you want to upload content, you will have to do that with a separate
     * call (the {@link com.slickqa.client.apiparts.FilesApi#addChunk(byte[]) addChunk} method of
     * the {@link com.slickqa.client.apiparts.FilesApi FilesApi}).
     *
     * @param storedFile The meta-data about the file you want to add.
     * @return The StoredFile object saved by slick (with the id).
     * @throws SlickError If there was a problem talking to slick.
     */
    public StoredFile create(StoredFile storedFile) throws SlickError;

    /**
     * Create a new StoredFile in slick, and upload the content from a local file path.
     * The mime type will be guessed based on file extension.
     *
     * @param localPath The local path to open the file and upload it.
     * @return A StoredFile (with id) if everything was successful.
     * @throws SlickError if an IO Exception occurs or there is a problem talking with slick.
     */
    public StoredFile createAndUpload(Path localPath) throws SlickError;

    /**
     * Create a new StoredFile in slick, and upload the content from an {@link java.io.InputStream}.
     *
     * @param filename The name of the file (used in creating the {@link com.slickqa.client.model.StoredFile}).
     * @param mimetype The mime type of the file.
     * @param stream The input stream to read from.
     * @return The {@link com.slickqa.client.model.StoredFile} saved by slick.
     * @throws SlickError if an error reading the steam occurs, or if any error occurs while creating the object or uploading the content.
     */
    public StoredFile createAndUpload(String filename, String mimetype, InputStream stream) throws SlickError;
}
