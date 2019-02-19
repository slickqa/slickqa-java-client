package com.slickqa.client.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Tests to make sure that the models are valid, working java beans.
 */
@RunWith(Parameterized.class)
public class ModelTest {

    @Parameters
    public static Collection<Object[]> parameters() throws Exception {
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[] {Build.class});
        params.add(new Object[] {BuildReference.class});
        params.add(new Object[] {Component.class});
        params.add(new Object[] {ComponentReference.class});
        params.add(new Object[] {Configuration.class});
        params.add(new Object[] {ConfigurationOverride.class});
        params.add(new Object[] {DataDrivenProperty.class});
        params.add(new Object[] {Feature.class});
        params.add(new Object[] {FeatureReference.class});
        params.add(new Object[] {Link.class});
        params.add(new Object[] {LogEntry.class});
        params.add(new Object[] {ProductVersion.class});
        params.add(new Object[] {Project.class});
        params.add(new Object[] {ProjectReference.class});
        params.add(new Object[] {Release.class});
        params.add(new Object[] {ReleaseReference.class});
        params.add(new Object[] {Result.class});
        params.add(new Object[] {ResultReference.class});
        params.add(new Object[] {ResultsByStatus.class});
        params.add(new Object[] {SlickLogEvent.class});
        params.add(new Object[] {Step.class});
        params.add(new Object[] {StoredFile.class});
        params.add(new Object[] {Testcase.class});
        params.add(new Object[] {TestcaseReference.class});
        params.add(new Object[] {TestPlan.class});
        params.add(new Object[] {Testrun.class});
        params.add(new Object[] {TestrunGroup.class});
        params.add(new Object[] {TestrunReference.class});
        params.add(new Object[] {TestrunSummary.class});
        params.add(new Object[] {UserAccount.class});
        return params;
    }

    @Parameter
    public Class<?> type;

    @Test
    public void beanTest() {
        assertThat(type, allOf(hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanToString()));
    }
}
