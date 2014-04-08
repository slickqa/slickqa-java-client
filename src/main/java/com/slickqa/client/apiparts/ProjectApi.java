package com.slickqa.client.apiparts;

import com.slickqa.client.model.Project;
import com.slickqa.client.model.Release;

/**
 * The project api, has more than the simple RetrieveUpdateDeleteApi as it deals with releases, and components.
 *
 * Created by jcorbett on 4/6/14.
 */
public interface ProjectApi extends RetrieveUpdateDeleteApi<Project> {
    /**
     * Query for all the releases, no filtering.
     */
    public QueryAndCreateApi<Release> releases();

    /**
     * Use a specific release.
     *
     * @param idOrName The id or name of the release.
     */
    public ReleaseApi release(String idOrName);
}
