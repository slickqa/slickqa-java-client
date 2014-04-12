package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;

import java.util.List;

/**
 * A simple interface allowing querying of the Slick server using information previously
 * entered into the parent (object parent, not inheritance parent).
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/6/14.
 */
public interface QueryAndCreateApi<T> {

    /**
     * Retreive a list of the specified object.
     *
     * @return The list of objects returned from slick.
     * @throws SlickError if an invalid usage occurs or if the server returns an error.
     */
    public List<T> getList() throws SlickError;

    /**
     * Create a new item.
     *
     * @param item The details of what to create
     * @return The created item (with the id filled in by the server)
     * @throws SlickError if an invalid usage occurs or if the server returns an error.
     */
    public T create(T item) throws SlickError;

    /**
     * Find the specified item, or create it.  You need to specify enough data about the item for creation.
     *
     * @param item The details of what to create (if needed)
     * @return The found or created item (with the id filled in by the server)
     * @throws SlickError if an invalid usage occurs or if the server returns an error.
     */
    public T findOrCreate(T item) throws SlickError;
}
