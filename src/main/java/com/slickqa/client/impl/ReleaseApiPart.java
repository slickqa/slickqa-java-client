package com.slickqa.client.impl;

import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.apiparts.ReleaseApi;
import com.slickqa.client.apiparts.RetrieveUpdateDeleteApi;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.Build;
import com.slickqa.client.model.Release;

import javax.ws.rs.client.WebTarget;

/**
 * Created by jcorbett on 4/12/14.
 */
public class ReleaseApiPart extends ApiPart<Release> implements ReleaseApi {

    private String contextPathOne;
    private String contextPathTwo;
    private ApiPart<Build> buildApiPart;


    public ReleaseApiPart(ParentApiPart parentApiPart) {
        super(Release.class, parentApiPart);
        contextPathOne = null;
        contextPathTwo = null;
        buildApiPart = new ApiPart<>(Build.class, this);
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
    public QueryAndCreateApi<Build> builds() {
        contextPathOne = "builds";
        return buildApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<Build> build(String idOrName) {
        contextPathOne = "builds";
        contextPathTwo = idOrName;
        return buildApiPart;
    }
}
