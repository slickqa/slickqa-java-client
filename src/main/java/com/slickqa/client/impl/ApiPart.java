package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.apiparts.RetrieveUpdateDeleteApi;
import com.slickqa.client.errors.SlickError;

import javax.ws.rs.client.WebTarget;
import java.util.List;

/**
 * Generic Query and CRUD Api Part.
 * Created by jcorbett on 4/7/14.
 */
public class ApiPart<T> implements RetrieveUpdateDeleteApi<T>, QueryAndCreateApi<T>, ParentApiPart {

    private ParentApiPart parent;

    public ApiPart(Class<T> type, ParentApiPart parent) {
        this.parent = parent;
    }

    //------------------------------ ParentApiPart -------------------------------------

    @Override
    public WebTarget getWebTarget() {
        return getParent().getWebTarget();
    }

    @Override
    public ParentApiPart getParent() {
        return parent;
    }

    @Override
    public SlickClient getSlickClient() {
        return null;
    }

    //------------------------------ RetrieveUpdateDeleteApi -------------------------------------

    @Override
    public T get() throws SlickError {
        return null;
    }

    @Override
    public T update(T item) throws SlickError {
        return null;
    }

    @Override
    public void delete() throws SlickError {

    }

    //------------------------------ QueryAndCreateApi -------------------------------------

    @Override
    public List<T> getList() throws SlickError {
        return null;
    }

    @Override
    public T create(T item) throws SlickError {
        return null;
    }

    @Override
    public T findOrCreate(T item) {
        return null;
    }
}
