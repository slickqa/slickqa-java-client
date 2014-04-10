package com.slickqa.client.errors;

/**
 * This is a parent class for any usage error relating to the slick client api.
 * Created by jcorbett on 4/7/14.
 */
public class SlickApiUsageError extends SlickError {
    public SlickApiUsageError(String message) {
        super(message);
    }
}
