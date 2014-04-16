package com.slickqa.client.errors;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.ws.rs.core.Response;

/**
 * Created by jcorbett on 4/16/14.
 */
public class SlickCommunicationErrorTest {

    @Test
    public void verifyInformationAvailable() {
        Exception inner = new Exception();
        Response response = Response.noContent().status(500).build();
        String url = "http://hello/world";

        SlickCommunicationError error = new SlickCommunicationError(url, response);
        assertThat(error.getMessage(), containsString(url));
        assertSame(response, error.getResponse());

        error = new SlickCommunicationError(url, response, inner);
        assertThat(error.getMessage(), containsString(url));
        assertSame(response, error.getResponse());
        assertSame(inner, error.getCause());
    }
}
