package com.slickqa.util;

import java.util.Iterator;

/**
 * Created by jcorbett on 4/13/14.
 */
public final class StringUtility {
    private StringUtility() {}

    public static String join(Iterable<String> strings, String joiner) {
        StringBuilder retval = new StringBuilder();
        Iterator<String> iter = strings.iterator();
        while(iter.hasNext()) {
            String part = iter.next();
            retval.append(part);
            if(iter.hasNext()) {
                retval.append(joiner);
            }
        }
        return retval.toString();
    }
}
