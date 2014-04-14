package com.slickqa.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jcorbett on 4/13/14.
 */
public class StringUtilityTest {

    @Test
    public void joinEmptyList() {
        List<String> input = new ArrayList<>();
        String joiner = ", ";
        String expectedOutput = "";
        assertEquals(expectedOutput, StringUtility.join(input, joiner));
    }

    @Test
    public void joinSingleElement() {
        List<String> input = new ArrayList<>();
        input.add("foo");
        String joiner = ", ";
        String expectedOutput = "foo";

        assertEquals(expectedOutput, StringUtility.join(input, joiner));
    }

    @Test
    public void joinMultipleElements() {
        List<String> input = new ArrayList<>();
        input.add("foo");
        input.add("bar");
        input.add("hello");
        String joiner = ", ";
        String expectedOutput = "foo, bar, hello";
        assertEquals(expectedOutput, StringUtility.join(input, joiner));
    }
}
