package com.slickqa.client;

import com.slickqa.client.impl.SlickClientImpl;

/**
 * Factory class for creating SlickClient instances.
 *
 * Created by jcorbett on 4/7/14.
 */
public class SlickClientFactory {
    public static SlickClient getSlickClient(String baseUrl) {
        return new SlickClientImpl(baseUrl);
    }
}
