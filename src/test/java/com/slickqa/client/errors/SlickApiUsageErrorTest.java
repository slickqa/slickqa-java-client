package com.slickqa.client.errors;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Tests for SlickApiUsageError class
 * Created by jcorbett on 4/16/14.
 */
public class SlickApiUsageErrorTest {

    @Test
    public void makeSureErrorMessageIsSame() {
        String message = "foo bar";
        SlickApiUsageError error = new SlickApiUsageError(message);
        assertSame(message, error.getMessage());
    }
}
