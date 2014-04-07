package com.slickqa.client.apiparts;

import com.slickqa.client.model.Build;
import com.slickqa.client.model.Release;

/**
 * The release api extends the basic CRUD Api by adding build related operations.
 * Created by jcorbett on 4/7/14.
 */
public interface ReleaseApi extends CRUDApi<Release> {
    /**
     * Query for all the builds belonging to this release, no filtering.
     */
    public QueryApi<Build> builds();

    /**
     * Use a specific build.  Use this form for create or update operations.  It will also work for get and delete
     * operations, but it is not required.
     *
     * @param build The build to use for the request
     */
    public CRUDApi<Build> build(Build build);

    /**
     * Use a specific release.  You can use this form only for get or delete operations.  Using this form for create or
     * update operations can cause an SlickApiUsageError.
     *
     * @param idOrName The id or name of the build
     */
    public CRUDApi<Build> build(String idOrName);
}
