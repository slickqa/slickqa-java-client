package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;

/**
 * API for doing basic Retrieve, Update, and Delete for various types.
 * Create happens on the QueryAndCreateApi
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/7/14.
 */
public interface RetrieveUpdateDeleteApi<T> {

    /**
     * Retrieve a specific object.
     * @return The object returned from slick.
     * @throws SlickError on errors reported from the slick server.
     */
    public T get() throws SlickError;

    /**
     * Update an object.
     * @return The updated object as returned by slick.
     * @throws SlickError if the slick server returns an error.
     * @param update Update object
     */
    public T update(T update) throws SlickError;

    /**
     * Delete the specified object.
     * @throws SlickError if the slick server returns an error
     */
    public void delete() throws SlickError;
}
