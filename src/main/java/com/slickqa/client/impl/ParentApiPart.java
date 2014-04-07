package com.slickqa.client.impl;

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
}
