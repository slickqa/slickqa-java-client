package com.slickqa.client.impl;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertSame;

/**
 * Created by jcorbett on 4/12/14.
 */
public class ReleaseApiPartTest {
    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget parentTarget;

    @Injectable
    WebTarget secondTarget;

    @Injectable
    WebTarget thirdTarget;

    @Tested
    ReleaseApiPart releaseApiPart;

    @Test
    public void getWebTargetReturnsParentWIthoutContext() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;
        }};
        WebTarget retval = releaseApiPart.getWebTarget();
        assertSame("Without any other method called, the webtarget returned from getWebTarget should be the same instance the parent gives.", parentTarget, retval);
    }

    @Test
    public void releasesCausesPathAddedToWebTarget() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("builds");
            result = secondTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        releaseApiPart.builds();
        assertSame(secondTarget, releaseApiPart.getWebTarget());
        assertSame(parentTarget, releaseApiPart.getWebTarget());
    }

    @Test
    public void releaseWithIdAddsTwoPathsToWebTarget() throws Exception {
        final String buildId = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("builds");
            result = secondTarget;

            secondTarget.path(buildId);
            result = thirdTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        releaseApiPart.build(buildId);
        assertSame(thirdTarget, releaseApiPart.getWebTarget());
        assertSame(parentTarget, releaseApiPart.getWebTarget());
    }
}
