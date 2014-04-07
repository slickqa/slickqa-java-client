package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.sun.jersey.api.client.Client;

/**
 * Used internally for describing the interface from which to get contextual information from the parent.
 *
 * Created by jcorbett on 4/7/14.
 */
public interface ParentApiPart {
    public Object getContextObject();
    public String getContextId();
    public ParentApiPart getParent();
    public String getUrl();
    public Client getClient();
    public SlickClient getSlickClient();
}
