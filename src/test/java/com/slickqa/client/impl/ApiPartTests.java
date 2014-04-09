package com.slickqa.client.impl;

import mockit.Injectable;
import mockit.Mock;
import mockit.NonStrictExpectations;
import mockit.Tested;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.*;

/**
 * Created by jcorbett on 4/8/14.
 */
public class ApiPartTests {

    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget webTarget;

    @Test
    public void getParentTest() {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent);
        ParentApiPart retval = apiPart.getParent();
        assertNotNull("The parent of the apiPart should be the one injected, not null.", retval);
        assertSame("The parent of the apiPart should be the one injected.", retval, parent);
    }

    @Test
    public void getWebTargetPassThroughTest() {
        ApiPart<Object> apiPart = new ApiPart<>(Object.class, parent);
        new NonStrictExpectations() {{
            parent.getWebTarget();
            result = webTarget;
        }};
        WebTarget retval = apiPart.getWebTarget();
        assertNotNull("A non null webtarget should be returned from getWebTarget().", retval);
        assertSame("The web target returned from getWebTarget should be the one from the parent, this apipart has nothing to add.", retval, webTarget);
    }
}
