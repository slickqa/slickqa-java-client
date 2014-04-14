package com.slickqa.client.impl;

import com.slickqa.util.MapUtility;
import mockit.Expectations;
import mockit.Injectable;
import org.junit.Before;
import org.junit.Test;

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
}
