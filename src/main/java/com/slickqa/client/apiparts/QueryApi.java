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
public interface QueryApi<T> {

    /**
     * Retreive a list of the specified object.
     *
     * @return The list of objects returned from slick.
     * @throws SlickError if an invalid usage occurs or if the server returns an error.
     */
    public List<T> getList() throws SlickError;
}
