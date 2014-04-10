package com.slickqa.client.errors;

import javax.ws.rs.core.Response;
import java.text.MessageFormat;

/**
 * This is a parent to any slick error that happens while communicating with the slick server.
 * Created by jcorbett on 4/7/14.
 */
public class SlickCommunicationError extends SlickError {
    private Response response;
    public SlickCommunicationError(String url, Response response) {
        super(MessageFormat.format("Error communicating with slick at url '{0}', response: '{1}'", url, response));
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
