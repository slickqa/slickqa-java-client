package com.slickqa.client.apiparts;

import com.slickqa.client.model.Build;
import com.slickqa.client.model.Release;

/**
 * The release api extends the basic CRUD Api by adding build related operations.
 * Created by jcorbett on 4/7/14.
 */
public interface ReleaseApi extends RetrieveUpdateDeleteApi<Release> {
    /**
     * Query for all the builds belonging to this release, no filtering.
     */
    public QueryAndCreateApi<Build> builds();

    /**
     * Use a specific release.
     *
     * @param idOrName The id or name of the build
     */
    public RetrieveUpdateDeleteApi<Build> build(String idOrName);
}
