package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.ProjectApi;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.Project;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.slickqa.util.StringUtility.join;

/**
 * Created by jcorbett on 4/12/14.
 */
public class SlickClientImpl implements SlickClient, ParentApiPart {
    private String contextPathOne;

    private String contextPathTwo;

    private String query;

    private String orderby;

    private String baseUrl;

    private Integer limit;

    private Integer skip;

    private ProjectApiPart projectApiPart;

    private Client restClient;

    public SlickClientImpl(String baseUrl, Client restClient) {
        this.baseUrl = baseUrl;
        this.restClient = restClient;
        contextPathOne = null;
        contextPathTwo = null;
        query = null;
        orderby = null;
        limit = null;
        skip = null;
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
        contextPathOne = "projects";
        if(properties != null && !properties.isEmpty()) {
            StringBuilder query = new StringBuilder();
            if (properties.size() > 1) {
                query.append("and(");
            }
            List<String> queries = new ArrayList<>(properties.size());
            for(Map.Entry<String, String> entry : properties.entrySet()) {
                queries.add(MessageFormat.format("eq({0},\"{1}\")", entry.getKey(), entry.getValue()));
            }
            query.append(join(queries, ","));
            if (properties.size() > 1) {
                query.append(")");
            }
            this.query = query.toString();
        }
        return projectApiPart;
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query) {
        return projects(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy) {
        return projects(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy, Integer limit, Integer skip) {
        contextPathOne = "projects";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return projectApiPart;
    }

    @Override
    public ProjectApi project(String idOrName) {
        contextPathOne = "projects";
        contextPathTwo = idOrName;
        return projectApiPart;
    }

    @Override
    public WebTarget getWebTarget() throws SlickError {
        WebTarget target = restClient.target(baseUrl);
        if (contextPathOne != null) {
            target = target.path(contextPathOne);
            // clear the context after it's used
            contextPathOne = null;
            if (contextPathTwo != null) {
                target = target.path(contextPathTwo);
                // clear the context after it's used
                contextPathTwo = null;
            }
        }

        if (query != null) {
            target = target.queryParam("q", query);
            query = null;
        }

        if (orderby != null) {
            target = target.queryParam("orderby", orderby);
            orderby = null;
        }

        if (limit != null) {
            target = target.queryParam("limit", limit);
            limit = null;
        }

        if (skip != null) {
            target = target.queryParam("skip", skip);
            skip = null;
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
