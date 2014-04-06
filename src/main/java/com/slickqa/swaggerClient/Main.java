package com.slickqa.swaggerClient;

import com.slickqa.swaggerClient.api.ProjectsApi;
import com.slickqa.swaggerClient.models.Project;
import com.wordnik.client.common.ApiException;

/**
 * Created by jcorbett on 4/6/14.
 */
public class Main {

    public static void main(String... args) {
        ProjectsApi projects = new ProjectsApi();
        try {
            for (Project p : projects.get_projects(null, null, null, null)) {
                System.out.println(p.getName());
            }
        } catch (ApiException e)
        {
            e.printStackTrace();
        }
    }
}
