package com.slickqa.client.impl;

import com.slickqa.util.MapUtility;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/**
 * Created by jcorbett on 4/12/14.
 */
@RunWith(JMockit.class)
public class SlickClientImplTest {

    @Injectable
    Client restClient;

    @Injectable
    WebTarget targetOne;

    @Injectable
    WebTarget targetTwo;

    @Injectable
    WebTarget targetThree;

    SlickClientImpl slickClient;

    String baseUrl;

    @Before
    public void setUp() {
        baseUrl = "http://localhost/slick";
        slickClient = new SlickClientImpl(baseUrl, restClient);
    }

    @Test
    public void getSlickClientReturnsSelf() {
        assertSame(slickClient, slickClient.getSlickClient());
    }

    @Test
    public void getParentReturnsNull() {
        assertNull("Calling null on the slick client should return null", slickClient.getParent());
    }

    @Test
    public void getWebTargetReturnsEmptyTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void projectsAddsPathToWebTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from projects method should not be null.", slickClient.projects());
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void projectAddsTwoPathsToWebTarget() throws Exception {
        final String projectId = "foo";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.path(projectId);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from project(id) method should not be null.", slickClient.project(projectId));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void projectQueryOnly() throws Exception {
        final String query = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from projects(query) method should not be null.", slickClient.projects(query));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void projectQueryAndOrderBy() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            restClient.target(baseUrl);
            result = targetTwo;
        }};

        assertNotNull("The return value from projects(query) method should not be null.", slickClient.projects(query, orderBy));
        assertSame(targetOne, slickClient.getWebTarget());
        assertSame(targetTwo, slickClient.getWebTarget());

    }

    @Test
    public void projectQueryOrderByLimitAndSkip() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        final Integer limit = 10;
        final Integer skip = 5;
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            targetOne.queryParam("limit", limit);
            result = targetTwo;

            targetTwo.queryParam("skip", skip);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from projects(query, orderby, limit, skip) method should not be null.", slickClient.projects(query, orderBy, limit, skip));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void projectPropertiesQueryEmptyHashMap() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from projects(properties) method should not be null.", slickClient.projects(new HashMap<String, String>()));
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void projectPropertiesQueryOneEntryHashMap() throws Exception {
        final String expectedQuery = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from projects(properties) method should not be null.", slickClient.projects(MapUtility.parameters("one", "two")));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void projectPropertiesQueryMultipleEntryHashMap() throws Exception {
        final String expectedQuery = "and(eq(foo,\"bar\"),eq(one,\"two\"))";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("projects");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("foo", "bar");
        parameters.put("one", "two");
        assertNotNull("The return value from projects(properties) method should not be null.", slickClient.projects(parameters));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void configurationsAddsPathToWebTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from configurations method should not be null.", slickClient.configurations());
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void configurationAddsTwoPathsToWebTarget() throws Exception {
        final String configurationId = "foo";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.path(configurationId);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from configuration(id) method should not be null.", slickClient.configuration(configurationId));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void configurationQueryOnly() throws Exception {
        final String query = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from configurations(query) method should not be null.", slickClient.configurations(query));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void configurationQueryAndOrderBy() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            restClient.target(baseUrl);
            result = targetTwo;
        }};

        assertNotNull("The return value from configurations(query) method should not be null.", slickClient.configurations(query, orderBy));
        assertSame(targetOne, slickClient.getWebTarget());
        assertSame(targetTwo, slickClient.getWebTarget());

    }

    @Test
    public void configurationQueryOrderByLimitAndSkip() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        final Integer limit = 10;
        final Integer skip = 5;
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            targetOne.queryParam("limit", limit);
            result = targetTwo;

            targetTwo.queryParam("skip", skip);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from configurations(query, orderby, limit, skip) method should not be null.", slickClient.configurations(query, orderBy, limit, skip));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void configurationPropertiesQueryEmptyHashMap() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from configurations(properties) method should not be null.", slickClient.configurations(new HashMap<String, String>()));
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void configurationPropertiesQueryOneEntryHashMap() throws Exception {
        final String expectedQuery = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from configurations(properties) method should not be null.", slickClient.configurations(MapUtility.parameters("one", "two")));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void configurationPropertiesQueryMultipleEntryHashMap() throws Exception {
        final String expectedQuery = "and(eq(foo,\"bar\"),eq(one,\"two\"))";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("configurations");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("foo", "bar");
        parameters.put("one", "two");
        assertNotNull("The return value from configurations(properties) method should not be null.", slickClient.configurations(parameters));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void resultsAddsPathToWebTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from results method should not be null.", slickClient.results());
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void resultAddsTwoPathsToWebTarget() throws Exception {
        final String resultId = "foo";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.path(resultId);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from result(id) method should not be null.", slickClient.result(resultId));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void resultQueryOnly() throws Exception {
        final String query = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from results(query) method should not be null.", slickClient.results(query));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void resultQueryAndOrderBy() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            restClient.target(baseUrl);
            result = targetTwo;
        }};

        assertNotNull("The return value from results(query) method should not be null.", slickClient.results(query, orderBy));
        assertSame(targetOne, slickClient.getWebTarget());
        assertSame(targetTwo, slickClient.getWebTarget());

    }

    @Test
    public void resultQueryOrderByLimitAndSkip() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        final Integer limit = 10;
        final Integer skip = 5;
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            targetOne.queryParam("limit", limit);
            result = targetTwo;

            targetTwo.queryParam("skip", skip);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from results(query, orderby, limit, skip) method should not be null.", slickClient.results(query, orderBy, limit, skip));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void resultPropertiesQueryEmptyHashMap() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from results(properties) method should not be null.", slickClient.results(new HashMap<String, String>()));
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void resultPropertiesQueryOneEntryHashMap() throws Exception {
        final String expectedQuery = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from results(properties) method should not be null.", slickClient.results(MapUtility.parameters("one", "two")));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void resultPropertiesQueryMultipleEntryHashMap() throws Exception {
        final String expectedQuery = "and(eq(foo,\"bar\"),eq(one,\"two\"))";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("results");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("foo", "bar");
        parameters.put("one", "two");
        assertNotNull("The return value from results(properties) method should not be null.", slickClient.results(parameters));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testplansAddsPathToWebTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testplans method should not be null.", slickClient.testplans());
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testplanAddsTwoPathsToWebTarget() throws Exception {
        final String testplanId = "foo";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.path(testplanId);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testplan(id) method should not be null.", slickClient.testplan(testplanId));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testplanQueryOnly() throws Exception {
        final String query = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from testplans(query) method should not be null.", slickClient.testplans(query));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testplanQueryAndOrderBy() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            restClient.target(baseUrl);
            result = targetTwo;
        }};

        assertNotNull("The return value from testplans(query) method should not be null.", slickClient.testplans(query, orderBy));
        assertSame(targetOne, slickClient.getWebTarget());
        assertSame(targetTwo, slickClient.getWebTarget());

    }

    @Test
    public void testplanQueryOrderByLimitAndSkip() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        final Integer limit = 10;
        final Integer skip = 5;
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            targetOne.queryParam("limit", limit);
            result = targetTwo;

            targetTwo.queryParam("skip", skip);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from testplans(query, orderby, limit, skip) method should not be null.", slickClient.testplans(query, orderBy, limit, skip));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void testplanPropertiesQueryEmptyHashMap() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testplans(properties) method should not be null.", slickClient.testplans(new HashMap<String, String>()));
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void testplanPropertiesQueryOneEntryHashMap() throws Exception {
        final String expectedQuery = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testplans(properties) method should not be null.", slickClient.testplans(MapUtility.parameters("one", "two")));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testplanPropertiesQueryMultipleEntryHashMap() throws Exception {
        final String expectedQuery = "and(eq(foo,\"bar\"),eq(one,\"two\"))";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testplans");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("foo", "bar");
        parameters.put("one", "two");
        assertNotNull("The return value from testplans(properties) method should not be null.", slickClient.testplans(parameters));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testcasesAddsPathToWebTarget() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testcases method should not be null.", slickClient.testcases());
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testcaseAddsTwoPathsToWebTarget() throws Exception {
        final String testcaseId = "foo";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.path(testcaseId);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testcase(id) method should not be null.", slickClient.testcase(testcaseId));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testcaseQueryOnly() throws Exception {
        final String query = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from testcases(query) method should not be null.", slickClient.testcases(query));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testcaseQueryAndOrderBy() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            restClient.target(baseUrl);
            result = targetTwo;
        }};

        assertNotNull("The return value from testcases(query) method should not be null.", slickClient.testcases(query, orderBy));
        assertSame(targetOne, slickClient.getWebTarget());
        assertSame(targetTwo, slickClient.getWebTarget());

    }

    @Test
    public void testcaseQueryOrderByLimitAndSkip() throws Exception {
        final String query = "eq(one,\"two\")";
        final String orderBy = "-lastUpdated";
        final Integer limit = 10;
        final Integer skip = 5;
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.queryParam("q", query);
            result = targetThree;

            targetThree.queryParam("orderby", orderBy);
            result = targetOne;

            targetOne.queryParam("limit", limit);
            result = targetTwo;

            targetTwo.queryParam("skip", skip);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};

        assertNotNull("The return value from testcases(query, orderby, limit, skip) method should not be null.", slickClient.testcases(query, orderBy, limit, skip));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void testcasePropertiesQueryEmptyHashMap() throws Exception {
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testcases(properties) method should not be null.", slickClient.testcases(new HashMap<String, String>()));
        assertSame(targetTwo, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());

    }

    @Test
    public void testcasePropertiesQueryOneEntryHashMap() throws Exception {
        final String expectedQuery = "eq(one,\"two\")";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        assertNotNull("The return value from testcases(properties) method should not be null.", slickClient.testcases(MapUtility.parameters("one", "two")));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

    @Test
    public void testcasePropertiesQueryMultipleEntryHashMap() throws Exception {
        final String expectedQuery = "and(eq(foo,\"bar\"),eq(one,\"two\"))";
        new Expectations() {{
            restClient.target(baseUrl);
            result = targetOne;

            targetOne.path("testcases");
            result = targetTwo;

            targetTwo.queryParam("q",expectedQuery);
            result = targetThree;

            restClient.target(baseUrl);
            result = targetOne;
        }};
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("foo", "bar");
        parameters.put("one", "two");
        assertNotNull("The return value from testcases(properties) method should not be null.", slickClient.testcases(parameters));
        assertSame(targetThree, slickClient.getWebTarget());
        assertSame(targetOne, slickClient.getWebTarget());
    }

}
