package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.errors.SlickCommunicationError;
import mockit.*;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * Created by jcorbett on 4/8/14.
 */
public class ApiPartTest {

    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget webTarget;

    @Injectable
    SlickClient client;

    @Injectable
    ObjectMapper mapper;

    @Injectable
    Invocation.Builder builder;

    @Injectable
    Response response;

    @Test
    public void getParentTest() {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent);
        ParentApiPart retval = apiPart.getParent();
        assertNotNull("The parent of the apiPart should be the one injected, not null.", retval);
        assertSame("The parent of the apiPart should be the one injected.", retval, parent);
    }

    @Test
    public void getWebTargetPassThroughTest() {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent);
        new NonStrictExpectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};
        WebTarget retval = apiPart.getWebTarget();
        assertNotNull("A non null webtarget should be returned from getWebTarget().", retval);
        assertSame("The web target returned from getWebTarget should be the one from the parent, this apipart has nothing to add.", retval, webTarget);
    }

    @Test
    public void getSlickClientPassThroughTest() {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent);
        new NonStrictExpectations() {{
            parent.getSlickClient();
            result = client;
        }};
        SlickClient retval = apiPart.getSlickClient();
        assertNotNull("A non null slick client should be returned from getSlickClient().", retval);
        assertSame("The slick client returned from getSlickClient should be the one from the parent, this apipart should just return it.", retval, client);
    }

    @Test
    public void deleteNormalWorkflow() throws Exception {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent, mapper);
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            builder.delete();
            result = response;

            response.getStatus();
            result = 200;
        }};

        apiPart.delete();

    }

    @Test(expected = SlickCommunicationError.class)
    public void deleteErrorReturned() throws Exception {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent, mapper);
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            builder.delete();
            result = response;

            response.getStatus();
            result = 500;
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.delete();

    }


}
