package com.slickqa.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.SlickClient;
import com.slickqa.client.errors.SlickCommunicationError;
import mockit.*;
import org.junit.Before;
import org.junit.Test;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for com.slickqa.client.impl.ApiPart
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

    JavaType objectType;

    @Before
    public void setUp() {
        final ObjectMapper realMapper = JsonUtil.getObjectMapper();
        objectType = realMapper.constructType(Object.class);
        new NonStrictExpectations() {{
            mapper.constructType(Object.class);
            result = realMapper.constructType(Object.class);

            mapper.getTypeFactory();
            result = realMapper.getTypeFactory();
        }};
        apiPart = new ApiPart<>(Object.class, parent, mapper);
    }

    @Test
    public void getParentTest() {
        ParentApiPart retval = apiPart.getParent();
        assertNotNull("The parent of the apiPart should be the one injected, not null.", retval);
        assertSame("The parent of the apiPart should be the one injected.", retval, parent);
    }

    @Test
    public void getWebTargetPassThroughTest() throws Exception {
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

            builder.method("DELETE");
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

            builder.method("DELETE");
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

            mapper.readValue(jsonResponseString, withAny(objectType));
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

            mapper.readValue(jsonResponseString, withAny(objectType));
            //mapper.readValue(jsonResponseString, withAny(TypeReference.class));
            result = new JsonMappingException("");
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.get();

    }

    @Test
    public void updateObjectNormalWorkflow() throws Exception {
        final Object expectedResult = new Object();
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("PUT", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = expectedResult;
        }};
        Object retval = apiPart.update(toUpdate);
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expectedResult);
    }

    @Test(expected = SlickCommunicationError.class)
    public void updateObjectBadResponseCode() throws Exception {
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("PUT", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 500;
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.update(toUpdate);
    }

    @Test(expected = SlickCommunicationError.class)
    public void updateObjectMapperError() throws Exception {
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("PUT", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = new JsonMappingException("");
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.update(toUpdate);

    }

    @Test
    public void getListNormalWorkflow() throws Exception {
        final List<Object> expectedResult = new ArrayList<>();
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

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = expectedResult;
        }};
        List<Object> retval = apiPart.getList();
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expectedResult);
    }

    @Test(expected = SlickCommunicationError.class)
    public void getListBadResponseCode() throws Exception {
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

        apiPart.getList();
    }

    @Test(expected = SlickCommunicationError.class)
    public void getListMapperError() throws Exception {
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

            mapper.readValue(jsonResponseString, withAny(objectType));
            //mapper.readValue(jsonResponseString, withAny(TypeReference.class));
            result = new JsonMappingException("");
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.getList();
    }

    @Test
    public void createObjectNormalWorkflow() throws Exception {
        final Object expectedResult = new Object();
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = expectedResult;
        }};
        Object retval = apiPart.create(toUpdate);
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expectedResult);
    }

    @Test(expected = SlickCommunicationError.class)
    public void createObjectBadResponseCode() throws Exception {
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 500;
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.create(toUpdate);
    }

    @Test(expected = SlickCommunicationError.class)
    public void createObjectMapperError() throws Exception {
        final Object toUpdate = new Object();
        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(toUpdate));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = new JsonMappingException("");
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        apiPart.create(toUpdate);

    }

    @Test
    public void findOrCreateFoundItem() throws Exception {
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

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = expectedResult;
        }};
        Object retval = apiPart.findOrCreate(new Object());
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expectedResult);
    }

    @Test
    public void findOrCreateMustCreate() throws Exception {
        final Object passedIn = new Object();
        final Object expected = new Object();
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
            result = 404;
        }};
        new Expectations() {{
            webTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        final String updateJson = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(passedIn));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(objectType));
            result = expected;
        }};
        Object retval = apiPart.findOrCreate(passedIn);
        assertSame("Instance should be the same instance that is returned from the mapper.", retval, expected);
    }

}
