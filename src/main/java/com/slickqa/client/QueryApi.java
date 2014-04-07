package com.slickqa.client;

import java.util.List;

/**
 * Created by jcorbett on 4/6/14.
 */
public interface QueryApi<T> {
    public List<T> getList();
}
