package com.slickqa.client.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slickqa.client.errors.SlickCommunicationError;
import com.slickqa.client.model.LogEntry;
import mockit.Expectations;
import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

/**
 * Tests for ResultApiPart
 * Created by jcorbett on 4/16/14.
 */
@RunWith(JMockit.class)
public class ResultApiPartTest {
    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget webTarget;

    @Injectable
    WebTarget secondTarget;

    @Injectable
    WebTarget thirdTarget;

    @Injectable
    ObjectMapper mapper;

    @Injectable
    Invocation.Builder builder;

    @Injectable
    Response response;

    @Tested
    ResultApiPart resultApiPart;

    String jsonResponseString = "{}";

    JavaType intType;

    @Before
    public void setUp() {
        final ObjectMapper realMapper = JsonUtil.getObjectMapper();
        intType = realMapper.constructType(Integer.class);
        new NonStrictExpectations() {{
            mapper.constructType(Integer.class);
            result = realMapper.constructType(Integer.class);

            mapper.getTypeFactory();
            result = realMapper.getTypeFactory();

            mapper.constructType(LogEntry.class);
            result = realMapper.constructType(LogEntry.class);
        }};
    }

    @Test
    public void countNormalWorkflow() throws Exception {
        final Integer expectedResult = 4;
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.path("count");
            result = secondTarget;

            secondTarget.request();
            result = builder;

            builder.method("GET");
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(intType));
            result = expectedResult;
        }};

        assertSame(expectedResult, resultApiPart.count());
    }

    @Test(expected = SlickCommunicationError.class)
    public void countServerError() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.path("count");
            result = secondTarget;
        }};

        // retry up to 3 times when we get an error
        new Expectations(3) {{
            secondTarget.request();
            result = builder;

            builder.method("GET");
            result = response;

            response.getStatus();
            result = 500;
        }};
        new Expectations() {{
            secondTarget.getUri();
            result = new URI("http://foo/bar");
        }};

        resultApiPart.count();
    }

    @Test
    public void addLogsNormalWorkflow() throws Exception {
        final String updateJson = "[{}, {}]";
        final Integer expectedResult = 2;
        final List<LogEntry> body = new ArrayList<>();
        jsonResponseString = "2";
        new Expectations() {{
            parent.getWebTarget();
            result = webTarget;

            webTarget.path("log");
            result = secondTarget;

            secondTarget.request();
            result = builder;

            mapper.writeValueAsString(withSameInstance(body));
            result = updateJson;

            builder.method("POST", withAny(javax.ws.rs.client.Entity.entity(updateJson, MediaType.APPLICATION_JSON)));
            result = response;

            response.getStatus();
            result = 200;

            response.readEntity(String.class);
            result = jsonResponseString;

            mapper.readValue(jsonResponseString, withAny(intType));
            result = expectedResult;
        }};

        assertSame(expectedResult, resultApiPart.addLogs(body));
    }
}
