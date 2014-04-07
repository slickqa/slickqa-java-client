package com.slickqa.client.impl;

import com.slickqa.client.apiparts.CRUDApi;
import com.slickqa.client.errors.SlickError;

/**
 * Generic CRUD Api Part.
 * Created by jcorbett on 4/7/14.
 */
public class CRUDApiPart<T> implements CRUDApi<T> {

    public CRUDApiPart(Class<T> type, String urlpart, ParentApiPart parent)
    {
    }

    @Override
    public T get() throws SlickError {
        return null;
    }

    @Override
    public T update() throws SlickError {
        return null;
    }

    @Override
    public T create() throws SlickError {
        return null;
    }

    @Override
    public void delete() throws SlickError {

    }

    @Override
    public T getOrCreate() throws SlickError {
        return null;
    }
}
