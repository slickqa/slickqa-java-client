package com.slickqa.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.errors.SlickCommunicationError;
import mockit.*;
import org.junit.Before;
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

    String jsonResponseString = "{}";

    ApiPart<Object> apiPart;

    @Before
    public void setUp() {
        apiPart = new ApiPart<>(Object.class, parent, mapper);
    }

    @Test
    public void getParentTest() {
        ParentApiPart retval = apiPart.getParent();
        assertNotNull("The parent of the apiPart should be the one injected, not null.", retval);
        assertSame("The parent of the apiPart should be the one injected.", retval, parent);
    }

    @Test
    public void getWebTargetPassThroughTest() {
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

    @Test
    public void getObjectNormalWorkflow() throws Exception {
        final Object expectedResult = new Object();
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            builder.method("GET");
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(new TypeReference<Object>() { }));
            result = expectedResult;
        }};
        Object retval = apiPart.get();
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expectedResult);
    }

    @Test(expected = SlickCommunicationError.class)
    public void getObjectBadResponseCode() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            builder.method("GET");
            result = response;

            response.getStatus();
            result = 500;
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.get();
    }

    @Test(expected = SlickCommunicationError.class)
    public void getObjectMapperError() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            builder.method("GET");
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(new TypeReference<Object>() { }));
            //mapper.readValue(jsonResponseString, withAny(TypeReference.class));
            result = new JsonMappingException("");
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.get();

    }


}
