package com.slickqa.client;

import com.slickqa.client.impl.SlickClientImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Tests for SlickClientFactory
 * Created by jcorbett on 4/16/14.
 */
public class SlickClientFactoryTest {
    @Test
    public void factoryReturnsSlickClientImplInstance() {
        SlickClient instance = SlickClientFactory.getSlickClient("http://foo/bar");
        assertNotNull(instance);
        assertThat(instance, instanceOf(SlickClientImpl.class));
    }
}
