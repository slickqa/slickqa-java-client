package com.slickqa.client.apiparts;

import com.slickqa.client.model.Project;
import com.slickqa.client.model.Release;

/**
 * The project api, has more than the simple CRUDApi as it deals with releases, and components.
 *
 * Created by jcorbett on 4/6/14.
 */
public interface ProjectApi extends CRUDApi<Project> {
    /**
     * Query for all the releases, no filtering.
     */
    public QueryApi<Release> releases();

    /**
     * Use a specific release.  Use this form for create or update operations.  It will also work for get and delete
     * operations, but it is not required.
     *
     * @param release The release to perform the operation on
     */
    public ReleaseApi release(Release release);

    /**
     * Use a specific release.  You can use this form only for get or delete operations.  Using this form for create or
     * update operations can cause an SlickApiUsageError.
     *
     * @param idOrName The id or name of the release.
     */
    public ReleaseApi release(String idOrName);
}
