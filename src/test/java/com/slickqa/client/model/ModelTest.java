package com.slickqa.client.model;

import com.google.common.reflect.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static com.google.common.reflect.ClassPath.ClassInfo;
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
        for(ClassInfo info: ClassPath.from(Project.class.getClassLoader()).getTopLevelClasses(Project.class.getPackage().getName())) {
            params.add(new Object[] {info.load()});
        }
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
