package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.apiparts.RetrieveUpdateDeleteApi;
import com.slickqa.client.errors.SlickCommunicationError;
import com.slickqa.client.errors.SlickError;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Generic Query and CRUD Api Part.
 * Created by jcorbett on 4/7/14.
 */
public class ApiPart<T> implements RetrieveUpdateDeleteApi<T>, QueryAndCreateApi<T>, ParentApiPart {

    private ParentApiPart parent;

    public ApiPart(Class<T> type, ParentApiPart parent, ObjectMapper mapper) {
        this.parent = parent;
    }

    public ApiPart(Class<T> type, ParentApiPart parent) {
        this(type, parent, JsonUtil.getObjectMapper());
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
        return getParent().getSlickClient();
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
        WebTarget target = getParent().getWebTarget();
        Response lastResponse = null;
        for(int i = 0; i < 3; i++) {
            lastResponse = target.request().delete();
            if (lastResponse.getStatus() == 200)
                return;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // do nothing, we really don't care
            }
        }
        // if we haven't gotten a good response code
        throw new SlickCommunicationError(target.getUri().toString(), lastResponse);
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
