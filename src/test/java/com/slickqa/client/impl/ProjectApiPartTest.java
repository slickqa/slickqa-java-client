package com.slickqa.client.impl;

import com.slickqa.client.errors.SlickError;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertSame;

/**
 * Created by jcorbett on 4/12/14.
 */
public class ProjectApiPartTest {
    @Injectable
    ParentApiPart parent;

    @Injectable
    WebTarget parentTarget;

    @Injectable
    WebTarget secondTarget;

    @Injectable
    WebTarget thirdTarget;

    @Tested
    ProjectApiPart projectApiPart;

    @Test
    public void getWebTargetReturnsParentWIthoutContext() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;
        }};
        WebTarget retval = projectApiPart.getWebTarget();
        assertSame("Without any other method called, the webtarget returned from getWebTarget should be the same instance the parent gives.", parentTarget, retval);
    }

    @Test
    public void releasesCausesPathAddedToWebTarget() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("releases");
            result = secondTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        projectApiPart.releases();
        assertSame(secondTarget, projectApiPart.getWebTarget());
        assertSame(parentTarget, projectApiPart.getWebTarget());
    }

    @Test
    public void releaseWithIdAddsTwoPathsToWebTarget() throws Exception {
        final String releaseId = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("releases");
            result = secondTarget;

            secondTarget.path(releaseId);
            result = thirdTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        projectApiPart.release(releaseId);
        assertSame(thirdTarget, projectApiPart.getWebTarget());
        assertSame(parentTarget, projectApiPart.getWebTarget());
    }

    @Test
    public void componentsCausesPathAddedToWebTarget() throws Exception {
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("components");
            result = secondTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        projectApiPart.components();
        assertSame(secondTarget, projectApiPart.getWebTarget());
        assertSame(parentTarget, projectApiPart.getWebTarget());
    }

    @Test
    public void componentWithIdAddsTwoPathsToWebTarget() throws Exception {
        final String componentId = "foo";
        new Expectations() {{
            parent.getWebTarget();
            result = parentTarget;

            parentTarget.path("components");
            result = secondTarget;

            secondTarget.path(componentId);
            result = thirdTarget;

            parent.getWebTarget();
            result = parentTarget;
        }};
        projectApiPart.component(componentId);
        assertSame(thirdTarget, projectApiPart.getWebTarget());
        assertSame(parentTarget, projectApiPart.getWebTarget());
    }
}
