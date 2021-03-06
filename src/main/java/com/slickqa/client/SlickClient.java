package com.slickqa.client;

import com.slickqa.client.apiparts.*;
import com.slickqa.client.model.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The main interface for a slick client api. The slick client api is a builder pattern for making requests.
 * This means that parameters passed into a parent object will be the context for what the child object will do.
 * Because of this you do not want to keep reference to any of the Api instances other than the SlickClient instance.
 *
 * Ok, that was probably too boring to help.  So how about 3 concise code samples to show how to use the api.
 *
 * <h3>Example 1</h3>
 *
 * <p>In this example we will simply fetch a list of projects from slick, then print them out to the console.
 * This example is purposefully simplistic.  It shows how to get started.</p>
 *
 * <pre class="brush:java">
 *     SlickClient slick = SlickClientFactory.getSlickClient("http://localhost/slick/api");
 *     List&lt;Project&gt; projects = null;
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
 * </pre>
 *
 * @author Jason Corbett
 * Created by jcorbett on 4/6/14.
 */
public interface SlickClient
{
    /**
     * This is for use with Espresso which wants to know if it's busy.
     */
    public static AtomicInteger OpenConnectionCount = new AtomicInteger(0);

    /**
     * No filtering, retrieve all projects.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Project> projects();

    /**
     * Filter based on properties of a project.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the projects by.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Project> projects(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Project> projects(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return QueryAndCreateApi
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
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Project> projects(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific project.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the project.
     * @return ProjectApi
     */
    public ProjectApi project(String idOrName);

    /**
     * No filtering, retrieve all configurations.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Configuration> configurations();

    /**
     * Filter based on properties of a configuration.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the configurations by.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Configuration> configurations(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Configuration> configurations(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Configuration> configurations(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).  For any
     * parameters you don't want to specify, null is allowed.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Configuration> configurations(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific configuration.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the configuration.
     * @return RetrieveUpdateDeleteApi
     */
    public RetrieveUpdateDeleteApi<Configuration> configuration(String idOrName);

    /**
     * No filtering, retrieve all results.
     * @return ResultQueryApi
     */
    public ResultQueryApi results();

    /**
     * Filter based on properties of a result.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the results by.
     * @return ResultQueryApi
     */
    public ResultQueryApi results(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return ResultQueryApi
     */
    public ResultQueryApi results(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return ResultQueryApi
     */
    public ResultQueryApi results(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).  For any
     * parameters you don't want to specify, null is allowed.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     * @return ResultQueryApi
     */
    public ResultQueryApi results(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific result.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the result.
     * @return ResultApi
     */
    public ResultApi result(String idOrName);

    /**
     * No filtering, retrieve all testplans.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<TestPlan> testplans();

    /**
     * Filter based on properties of a testplan.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the testplans by.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<TestPlan> testplans(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<TestPlan> testplans(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<TestPlan> testplans(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).  For any
     * parameters you don't want to specify, null is allowed.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<TestPlan> testplans(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific testplan.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the testplan.
     * @return RetrieveUpdateDeleteApi
     */
    public RetrieveUpdateDeleteApi<TestPlan> testplan(String idOrName);

    /**
     * No filtering, retrieve all testcases.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testcase> testcases();

    /**
     * Filter based on properties of a testcase.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the testcases by.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testcase> testcases(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testcase> testcases(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testcase> testcases(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).  For any
     * parameters you don't want to specify, null is allowed.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testcase> testcases(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific testcase.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the testcase.
     * @return RetrieveUpdateDeleteApi
     */
    public RetrieveUpdateDeleteApi<Testcase> testcase(String idOrName);

    /**
     * Create and Upload a file to slick.  StoredFiles have to be created first before being added to a Result.
     * There is no generic query api for files.
     *
     * @return The api to create and possibly upload data for StoredFiles
     */
    public FilesQueryApi files();

    /**
     * Access a specific stored file.  You can update the metadata about the file, or add data to the file.
     *
     * @param id The id of the StoredFile that you want to access.
     * @return The Api for getting and updating a StoredFile
     */
    public FilesApi file(String id);

    /**
     * No filtering, retrieve all testruns.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testrun> testruns();

    /**
     * Filter based on properties of a testrun.  Dotted sub properties are allowed.
     * @param properties A map of properties and their values to filter the testruns by.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testrun> testruns(Map<String, String> properties);

    /**
     * Filter the results based of a standard slick query.
     * @param query The query to perform, using slick's generic query language.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testrun> testruns(String query);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testrun> testruns(String query, String orderBy);

    /**
     * Filter the results based of a standard slick query, setting a property to order the results by.  Also you can
     * specify a limit to the number of results and set a number of results to skip (for paging purposes).  For any
     * parameters you don't want to specify, null is allowed.
     *
     * @param query The query to perform, using slick's generic query language.
     * @param orderBy The name of the property to order the results by.  Prefix with a '-' for descending order.
     * @param limit The maximum number of results to return, or null for no limit.
     * @param skip The number of results to skip (maintaining order), or null for no skip.
     * @return QueryAndCreateApi
     */
    public QueryAndCreateApi<Testrun> testruns(String query, String orderBy, Integer limit, Integer skip);

    /**
     * Perform operations against a specific testrun.  You only need to enter the ID (or name) here.
     *
     * @param idOrName The id (string representation of the BSON Object Id) or the name of the testrun.
     * @return RetrieveUpdateDeleteApi
     */
    public RetrieveUpdateDeleteApi<Testrun> testrun(String idOrName);
}
