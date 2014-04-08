package com.slickqa.client;

import com.slickqa.client.apiparts.ProjectApi;
import com.slickqa.client.apiparts.QueryAndCreateApi;
import com.slickqa.client.model.Project;

import java.util.Map;

/**
 * The main interface for a slick client api. The slick client api is a builder pattern for making requests.
 * This means that parameters passed into a parent object will be the context for what the child object will do.
 * Because of this you do not want to keep reference to any of the Api instances other than the SlickClient instance.
 *
 * Ok, that was probably too boring to help.  So how about 3 concise code samples to show how to use the api.
 *
 * <h2>Example 1</h2>
 * In this example we will simply fetch a list of projects from slick, then print them out to the console.
 * This example is purposefully simplistic.  It shows how to get started.
 *
 * <code>
 *     SlickClient slick = SlickClientFactory.getSlickClient("http://localhost/slick")
 *     List<Project> projects = null;
 *     try {
 *         projects = slick.projects().getList();
 *     } catch(SlickError e) {
 *         System.err.println("Error retrieving list of projects from slick: " + e.getMessage());
 *     }
 *     if (projects != null) {
 *         System.out.println("Projects in slick:");
 *         System.out.println("------------------");
 *         for(Project project : projects) {
 *             System.out.println(project.toString());
 *         }
 *     } else {
 *         System.out.println("Nothing to see here, move along.");
 *     }
 * </code>
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/6/14.
 */
public interface SlickClient
{
    /**
     * No filtering, retrieve all projects.
     */
    public QueryAndCreateApi<Project> projects();

    /**
     * Filter based on properties of a project.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the projects by.
     */
    public QueryAndCreateApi<Project> projects(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     */
    public QueryAndCreateApi<Project> projects(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     */
    public QueryAndCreateApi<Project> projects(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     */
    public QueryAndCreateApi<Project> projects(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific project.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the project.
     */
    public ProjectApi project(String idOrName);
}
