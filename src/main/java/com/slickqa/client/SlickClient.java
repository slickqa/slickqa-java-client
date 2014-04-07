package com.slickqa.client;

import com.slickqa.client.apiparts.ProjectApi;
import com.slickqa.client.apiparts.QueryApi;
import com.slickqa.client.model.Project;

import java.util.Map;

/**
 * The main interface for a slick client api.
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/6/14.
 */
public interface SlickClient
{
    public QueryApi<Project> projects();
    public QueryApi<Project> projects(Map<String, String> properties);
    public QueryApi<Project> projects(String query);
    public QueryApi<Project> projects(String query, String orderBy);
    public QueryApi<Project> projects(String query, String orderBy, Integer limit, Integer skip);
    public ProjectApi project(Project project);
    public ProjectApi project(String idOrName);
}
