package com.slickqa.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcorbett on 4/6/14.
 */
public class MapUtility {
    public static Map<String, String> parameters(String... args) {
        HashMap<String, String> retval = new HashMap<>();
        if ((args.length % 2) != 0)
            throw new IllegalArgumentException("You must supply an even number of arguments to the parameters method.  There were " + args.length + " arguments.");

        if(args.length > 0) {
            for(int i = 0; i < args.length - 1; i += 2) {
                retval.put(args[i], args[i + 1]);
            }
        }
        return retval;
    }
}
