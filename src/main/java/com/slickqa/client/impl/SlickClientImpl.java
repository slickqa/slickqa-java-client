package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.ProjectApi;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.Project;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Map;

/**
 * Created by jcorbett on 4/12/14.
 */
public class SlickClientImpl implements SlickClient, ParentApiPart {
    private String contextPathOne;

    private String contextPathTwo;

    private String baseUrl;

    private ProjectApiPart projectApiPart;

    private Client restClient;

    public SlickClientImpl(String baseUrl, Client restClient) {
        this.baseUrl = baseUrl;
        this.restClient = restClient;
        contextPathOne = null;
        contextPathTwo = null;
        projectApiPart = new ProjectApiPart(this);
    }

    public SlickClientImpl(String baseUrl) {
        this(baseUrl, ClientBuilder.newClient());
    }

    @Override
    public QueryAndCreateApi<Project> projects() {
        contextPathOne = "projects";
        return projectApiPart;
    }

    @Override
    public QueryAndCreateApi<Project> projects(Map<String, String> properties) {
        return null;
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query) {
        return null;
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy) {
        return null;
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy, Integer limit, Integer skip) {
        return null;
    }

    @Override
    public ProjectApi project(String idOrName) {
        return null;
    }

    @Override
    public WebTarget getWebTarget() throws SlickError {
        WebTarget target = restClient.target(baseUrl);
        if (contextPathOne != null) {
            target = target.path(contextPathOne);
            // clear the context after it's used
            contextPathOne = null;
        }

        return target;
    }

    @Override
    public ParentApiPart getParent() {
        return null;
    }

    @Override
    public SlickClient getSlickClient() {
        return this;
    }
}
