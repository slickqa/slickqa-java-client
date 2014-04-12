package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.slickqa.client.errors.SlickError;

import javax.ws.rs.client.WebTarget;

/**
 * Used internally for describing the interface from which to get contextual information from the parent.
 *
 * Created by jcorbett on 4/7/14.
 */
public interface ParentApiPart {
    public WebTarget getWebTarget() throws SlickError;
    public ParentApiPart getParent();
    public SlickClient getSlickClient();
}
