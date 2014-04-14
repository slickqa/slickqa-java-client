package com.slickqa.client.impl;

import com.slickqa.client.apiparts.ProjectApi;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.apiparts.ReleaseApi;
import com.slickqa.client.apiparts.RetrieveUpdateDeleteApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.Component;
import com.slickqa.client.model.Project;
import com.slickqa.client.model.Release;

import javax.ws.rs.client.WebTarget;

/**
 * Created by jcorbett on 4/12/14.
 */
public class ProjectApiPart extends ApiPart<Project> implements ProjectApi {

    private String contextPathOne;
    private String contextPathTwo;
    private ReleaseApiPart releaseApiPart;
    private ApiPart<Component> componentApiPart;


    public ProjectApiPart(ParentApiPart parent) {
        super(Project.class, parent);
        contextPathOne = null;
        contextPathTwo = null;
        releaseApiPart = new ReleaseApiPart(this);
        componentApiPart = new ApiPart<>(Component.class, this);
    }

    @Override
    public WebTarget getWebTarget() throws SlickError {
        WebTarget target = getParent().getWebTarget();
        if (contextPathOne != null) {
            target = target.path(contextPathOne);
            // clear the context after it's used
            contextPathOne = null;
        }
        if (contextPathTwo != null) {
            target = target.path(contextPathTwo);
            // clear the context after it's used
            contextPathTwo = null;
        }
        return target;
    }


    @Override
    public QueryAndCreateApi<Release> releases() {
        contextPathOne = "releases";
        return releaseApiPart;
    }

    @Override
    public ReleaseApi release(String idOrName) {
        contextPathOne = "releases";
        contextPathTwo = idOrName;
        return releaseApiPart;
    }

    @Override
    public QueryAndCreateApi<Component> components() {
        contextPathOne = "components";
        return componentApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<Component> component(String idOrName) {
        contextPathOne = "components";
        contextPathTwo = idOrName;
        return componentApiPart;
    }
}
