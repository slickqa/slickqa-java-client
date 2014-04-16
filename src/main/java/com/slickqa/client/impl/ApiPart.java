package com.slickqa.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.apiparts.RetrieveUpdateDeleteApi;
import com.slickqa.client.errors.SlickCommunicationError;
import com.slickqa.client.errors.SlickError;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

/**
 * Generic Query and CRUD Api Part.
 * Created by jcorbett on 4/7/14.
 */
public class ApiPart<T> implements RetrieveUpdateDeleteApi<T>, QueryAndCreateApi<T>, ParentApiPart {

    protected ParentApiPart parent;
    protected ObjectMapper mapper;
    protected JavaType type;
    protected JavaType listType;

    public ApiPart(Class<T> type, ParentApiPart parent, ObjectMapper mapper) {
        this.parent = parent;
        this.mapper = mapper;
        this.type = mapper.constructType(type);
        this.listType = mapper.getTypeFactory().constructCollectionType(List.class, type);
    }

    public ApiPart(Class<T> type, ParentApiPart parent) {
        this(type, parent, JsonUtil.getObjectMapper());
    }

    protected WebTarget getWebTargetForRequest() throws SlickError {
        return getParent().getWebTarget();
    }


    protected <V> V makeRequest(String method, JavaType type, V body) throws SlickError {
        WebTarget target = getWebTargetForRequest();
        Response lastResponse = null;
        Exception lastException = null;
        for(int i = 0; i < 3; i++) {
            if(body != null) {
                try {
                    lastResponse = target.request().method(method, Entity.entity(mapper.writeValueAsString(body), MediaType.APPLICATION_JSON)); //, mapper.writeValueAsString(body));
                } catch (JsonProcessingException e) {
                    throw new SlickError(MessageFormat.format("Problem in JSON serialization of body for request to: {}", target.getUri().toString()), e);
                }
            } else {
                lastResponse = target.request().method(method);
            }
            if (lastResponse.getStatus() == 200) {
                if (type != null) {
                    try {
                        return mapper.readValue(lastResponse.readEntity(String.class), type);
                    } catch (IOException e) {
                        lastException = e;
                    }
                } else {
                    return null;
                }
            }
        }
        if(lastException != null)
            throw new SlickCommunicationError(target.getUri().toString(), lastResponse, lastException);
        else
            throw new SlickCommunicationError(target.getUri().toString(), lastResponse);
    }
    //------------------------------ ParentApiPart -------------------------------------

    @Override
    public WebTarget getWebTarget() throws SlickError {
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
        return makeRequest("GET", type, null);

    }

    @Override
    public T update(T item) throws SlickError {
        return makeRequest("PUT", type, item);
    }

    @Override
    public void delete() throws SlickError {
        makeRequest("DELETE", null, null);
    }

    //------------------------------ QueryAndCreateApi -------------------------------------

    @Override
    public List<T> getList() throws SlickError {
        return makeRequest("GET", listType, null);
    }

    @Override
    public T create(T item) throws SlickError {
        return makeRequest("POST", type, item);
    }

    @Override
    public T findOrCreate(T item) throws SlickError {
        try {
            return get();
        } catch (SlickError e) {}
        return create(item);
    }
}
