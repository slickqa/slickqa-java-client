package com.slickqa.util;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jcorbett on 4/6/14.
 */
public class MapUtilityTest {
    @Test
    public void parametersMapWithoutArguments()
    {
        Map<String, String> retval =  MapUtility.parameters();
        assertNotNull("parameters should not return null",retval);
        assertThat(retval, equalTo(Collections.<String,String>emptyMap()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parametersMapWithOddArguments()
    {
        MapUtility.parameters("foo", "bar", "hello");
    }

    @Test
    public void parametersMapWithEvenArguments()
    {
        Map<String, String> retval =  MapUtility.parameters("hello", "world", "foo", "bar");
        Map<String, String> expected = new HashMap<>();
        expected.put("hello", "world");
        expected.put("foo", "bar");
        assertThat(retval, is(equalTo(expected)));
    }
}
