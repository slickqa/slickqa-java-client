package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;

/**
 * API for doing basic Create, Update, and Delete for various types.
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/7/14.
 */
public interface CRUDApi<T> {

    /**
     * Retrieve a specific object.
     * @return The object returned from slick.
     * @throws SlickError on errors reported from the slick server.
     */
    public T get() throws SlickError;

    /**
     * Update an object.  You MUST pass in the instance in the parent object.  You CAN NOT use just the id or name.
     * @return The updated object as returned by slick.
     * @throws SlickError if the api is not used correctly (wrong form is used in parent), or if the slick server returns an error.
     */
    public T update() throws SlickError;

    /**
     * Create an object in slick.  You MUST pass in the instance in the parent object.  You CAN NOT use just the id or name.
     * @return The created object as returned by slick.  It will have the id assigned.
     * @throws SlickError if the api is not used correctly (wrong form is used in parent), or if the slick server returns an error.
     */
    public T create() throws SlickError;

    /**
     * Delete the specified object.
     * @throws SlickError if the slick server returns an error, or the needed id is not given.
     */
    public void delete() throws SlickError;

    /**
     * Try to get the object specified, but if it doesn't exist, create it.  You should pass in the instance in the
     * parent.
     *
     * @return The object from slick, created if necessary.
     * @throws SlickError if incorrect usage occurs (only specifying the id when a create needs to happen) or if the slick server returns an error
     */
    public T getOrCreate() throws SlickError;
}
