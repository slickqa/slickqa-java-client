package com.slickqa.client.apiparts;

import com.slickqa.client.errors.SlickError;

/**
 * API for doing basic Create, Update, and Delete for various types.
 *
 * Created by jcorbett on 4/7/14.
 */
public interface CRUDApi<T> {
    public T get() throws SlickError;
    public T update() throws SlickError;
    public T create() throws SlickError;
    public void delete() throws SlickError;
}
