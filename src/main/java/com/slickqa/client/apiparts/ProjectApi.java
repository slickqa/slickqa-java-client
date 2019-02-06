package com.slickqa.client.apiparts;

import com.slickqa.client.model.Component;
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
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Release> releases();

    /**
     * Use a specific release.
     *
     * @param idOrName The id or name of the release.
     * @return ReleaseApi
     */
    public ReleaseApi release(String idOrName);

    /**
     * Query for all the components belonging to the specified project.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Component> components();

    /**
     * Retrieve, update, or delete a specific component.
     * @param idOrName the id or name of the component.
     * @return RetrieveUpdateDeleteApi
     */
    public RetrieveUpdateDeleteApi<Component> component(String idOrName);
}
