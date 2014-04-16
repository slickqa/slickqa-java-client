package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.Result;

/**
 * The Result Query Api adds one method to the QueryAndCreateApi: count()
 *
 * Created by jcorbett on 4/14/14.
 */
public interface ResultQueryApi extends QueryAndCreateApi<Result> {
    /**
     * Count the number of results queried.
     * @return The number of results in the query.
     * @throws com.slickqa.client.errors.SlickError if there was a problem with communicating with the server
     */
    public int count() throws SlickError;
}
