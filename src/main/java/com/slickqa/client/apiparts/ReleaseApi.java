package com.slickqa.client.apiparts;

import com.slickqa.client.model.Build;
import com.slickqa.client.model.Release;

/**
 * The release api extends the basic CRUD Api by adding build related operations.
 * Created by jcorbett on 4/7/14.
 */
public interface ReleaseApi extends CRUDApi<Release> {
    public QueryApi<Build> builds();
    public CRUDApi<Build> build(Build build);
    public CRUDApi<Build> build(String idOrName);
}
