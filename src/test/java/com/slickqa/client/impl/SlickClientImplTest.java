package com.slickqa.client.impl;

import mockit.Expectations;
import mockit.Injectable;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

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
}
