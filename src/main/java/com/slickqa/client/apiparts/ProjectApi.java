package com.slickqa.client.apiparts;

import com.slickqa.client.model.Project;
import com.slickqa.client.model.Release;

/**
 * The project api, has more than the simple CRUDApi as it deals with releases, and components.
 *
 * Created by jcorbett on 4/6/14.
 */
public interface ProjectApi extends CRUDApi<Project> {
    public QueryApi<Release> releases();
    public ReleaseApi release(Release release);
    public ReleaseApi release(String idOrName);
}
