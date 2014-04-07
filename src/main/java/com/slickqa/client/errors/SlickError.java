package com.slickqa.client.errors;

/**
 * This is an error that's slick.  Just kidding, it is a generic error representing any type of error
 * that occurs while using the api.  There are 2 major types of errors:
 *
 * <ul>
 *     <li>Usage errors</li>
 *     <li>Communication errors</li>
 * </ul>
 *
 * Further subclasses will better define the type of error.
 *
 * Created by jcorbett on 4/7/14.
 */
public class SlickError extends Exception {
}
