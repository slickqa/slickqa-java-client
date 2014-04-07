package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;

import java.util.List;

/**
 * A simple interface allowing querying of the Slick server using information previously
 * entered into the parent (object parent, not inheritance parent).
 *
 * Created by jcorbett on 4/6/14.
 */
public interface QueryApi<T> {
    public List<T> getList() throws SlickError;
}
