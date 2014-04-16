package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.apiparts.ResultApi;
import com.slickqa.client.apiparts.ResultQueryApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.LogEntry;
import com.slickqa.client.model.Result;

import javax.ws.rs.client.WebTarget;
import java.util.List;

/**
 * Implementation of the additional apis that result allows
 * Created by jcorbett on 4/16/14.
 */
public class ResultApiPart extends ApiPart<Result> implements ResultQueryApi, ResultApi {

    private String contextPathOne;

    public ResultApiPart(ParentApiPart parent) {
        super(Result.class, parent);
        contextPathOne = null;
    }

    public ResultApiPart(ParentApiPart parent, ObjectMapper mapper) {
        super(Result.class, parent, mapper);
        contextPathOne = null;
    }

    @Override
    protected WebTarget getWebTargetForRequest() throws SlickError {
        WebTarget result = getParent().getWebTarget();
        if(contextPathOne != null) {
            result = result.path(contextPathOne);
            contextPathOne = null;
        }
        return result;
    }

    @Override
    public List<LogEntry> addLogs(List<LogEntry> logEntries) throws SlickError {
        contextPathOne = "log";
        return makeRequest("POST", mapper.getTypeFactory().constructCollectionType(List.class, mapper.constructType(LogEntry.class)), logEntries);
    }

    @Override
    public int count() throws SlickError {
        contextPathOne = "count";
        return makeRequest("GET", mapper.constructType(Integer.class), null);
    }
}
