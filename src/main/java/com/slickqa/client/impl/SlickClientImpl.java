package com.slickqa.client.impl;

import com.slickqa.client.SlickClient;
import com.slickqa.client.apiparts.*;
import com.slickqa.client.errors.SlickError;
import com.slickqa.client.model.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.slickqa.util.StringUtility.join;

/**
 * Created by jcorbett on 4/12/14.
 */
public class SlickClientImpl implements SlickClient, ParentApiPart {
    private String contextPathOne;

    private String contextPathTwo;

    private String query;

    private String orderby;

    private String baseUrl;

    private Integer limit;

    private Integer skip;

    private ProjectApiPart projectApiPart;

    private ApiPart<Configuration> configurationApiPart;

    private ApiPart<TestPlan> testplanApiPart;

    private ApiPart<Testcase> testcaseApiPart;

    private ApiPart<Testrun> testrunApiPart;

    private ResultApiPart resultApiPart;

    private Client restClient;

    public SlickClientImpl(String baseUrl, Client restClient) {
        this.baseUrl = baseUrl;
        this.restClient = restClient;
        contextPathOne = null;
        contextPathTwo = null;
        query = null;
        orderby = null;
        limit = null;
        skip = null;
        projectApiPart = new ProjectApiPart(this);
        configurationApiPart = new ApiPart<>(Configuration.class, this);
        resultApiPart = new ResultApiPart(this);
        testplanApiPart = new ApiPart<>(TestPlan.class, this);
        testcaseApiPart = new ApiPart<>(Testcase.class, this);
        testrunApiPart = new ApiPart<>(Testrun.class, this);
    }

    public SlickClientImpl(String baseUrl) {
        this(baseUrl, ClientBuilder.newClient());
    }

    private String createQueryFromProperties(Map<String, String> properties) {
        StringBuilder query = new StringBuilder();
        if (properties.size() > 1) {
            query.append("and(");
        }
        List<String> queries = new ArrayList<>(properties.size());
        for(Map.Entry<String, String> entry : properties.entrySet()) {
            queries.add(MessageFormat.format("eq({0},\"{1}\")", entry.getKey(), entry.getValue()));
        }
        query.append(join(queries, ","));
        if (properties.size() > 1) {
            query.append(")");
        }
        return query.toString();
    }

    @Override
    public QueryAndCreateApi<Project> projects() {
        contextPathOne = "projects";
        return projectApiPart;
    }

    @Override
    public QueryAndCreateApi<Project> projects(Map<String, String> properties) {
        contextPathOne = "projects";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return projectApiPart;
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query) {
        return projects(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy) {
        return projects(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<Project> projects(String query, String orderBy, Integer limit, Integer skip) {
        contextPathOne = "projects";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return projectApiPart;
    }

    @Override
    public ProjectApi project(String idOrName) {
        contextPathOne = "projects";
        contextPathTwo = idOrName;
        return projectApiPart;
    }

    @Override
    public QueryAndCreateApi<Configuration> configurations() {
        contextPathOne = "configurations";
        return configurationApiPart;
    }

    @Override
    public QueryAndCreateApi<Configuration> configurations(Map<String, String> properties) {
        contextPathOne = "configurations";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return configurationApiPart;
    }

    @Override
    public QueryAndCreateApi<Configuration> configurations(String query) {
        return configurations(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<Configuration> configurations(String query, String orderBy) {
        return configurations(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<Configuration> configurations(String query, String orderBy, Integer limit, Integer skip) {
        this.contextPathOne = "configurations";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return configurationApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<Configuration> configuration(String idOrName) {
        contextPathOne = "configurations";
        contextPathTwo = idOrName;
        return configurationApiPart;
    }

    @Override
    public ResultQueryApi results() {
        contextPathOne = "results";
        return resultApiPart;
    }

    @Override
    public ResultQueryApi results(Map<String, String> properties) {
        contextPathOne = "results";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return resultApiPart;
    }

    @Override
    public ResultQueryApi results(String query) {
        return results(query, null, null, null);
    }

    @Override
    public ResultQueryApi results(String query, String orderBy) {
        return results(query, orderBy, null, null);
    }

    @Override
    public ResultQueryApi results(String query, String orderBy, Integer limit, Integer skip) {
        this.contextPathOne = "results";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return resultApiPart;
    }

    @Override
    public ResultApi result(String idOrName) {
        contextPathOne = "results";
        contextPathTwo = idOrName;
        return resultApiPart;
    }

    @Override
    public QueryAndCreateApi<TestPlan> testplans() {
        contextPathOne = "testplans";
        return testplanApiPart;
    }

    @Override
    public QueryAndCreateApi<TestPlan> testplans(Map<String, String> properties) {
        contextPathOne = "testplans";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return testplanApiPart;
    }

    @Override
    public QueryAndCreateApi<TestPlan> testplans(String query) {
        return testplans(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<TestPlan> testplans(String query, String orderBy) {
        return testplans(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<TestPlan> testplans(String query, String orderBy, Integer limit, Integer skip) {
        this.contextPathOne = "testplans";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return testplanApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<TestPlan> testplan(String idOrName) {
        contextPathOne = "testplans";
        contextPathTwo = idOrName;
        return testplanApiPart;
    }

    @Override
    public QueryAndCreateApi<Testcase> testcases() {
        contextPathOne = "testcases";
        return testcaseApiPart;
    }

    @Override
    public QueryAndCreateApi<Testcase> testcases(Map<String, String> properties) {
        contextPathOne = "testcases";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return testcaseApiPart;
    }

    @Override
    public QueryAndCreateApi<Testcase> testcases(String query) {
        return testcases(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<Testcase> testcases(String query, String orderBy) {
        return testcases(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<Testcase> testcases(String query, String orderBy, Integer limit, Integer skip) {
        this.contextPathOne = "testcases";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return testcaseApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<Testcase> testcase(String idOrName) {
        contextPathOne = "testcases";
        contextPathTwo = idOrName;
        return testcaseApiPart;
    }

    @Override
    public QueryAndCreateApi<Testrun> testruns() {
        contextPathOne = "testruns";
        return testrunApiPart;
    }

    @Override
    public QueryAndCreateApi<Testrun> testruns(Map<String, String> properties) {
        contextPathOne = "testruns";
        if(properties != null && !properties.isEmpty()) {
            this.query = createQueryFromProperties(properties);
        }
        return testrunApiPart;
    }

    @Override
    public QueryAndCreateApi<Testrun> testruns(String query) {
        return testruns(query, null, null, null);
    }

    @Override
    public QueryAndCreateApi<Testrun> testruns(String query, String orderBy) {
        return testruns(query, orderBy, null, null);
    }

    @Override
    public QueryAndCreateApi<Testrun> testruns(String query, String orderBy, Integer limit, Integer skip) {
        this.contextPathOne = "testruns";
        this.query = query;
        this.orderby = orderBy;
        this.limit = limit;
        this.skip = skip;
        return testrunApiPart;
    }

    @Override
    public RetrieveUpdateDeleteApi<Testrun> testrun(String idOrName) {
        contextPathOne = "testruns";
        contextPathTwo = idOrName;
        return testrunApiPart;
    }

    @Override
    public WebTarget getWebTarget() throws SlickError {
        WebTarget target = restClient.target(baseUrl);
        if (contextPathOne != null) {
            target = target.path(contextPathOne);
            // clear the context after it's used
            contextPathOne = null;
            if (contextPathTwo != null) {
                target = target.path(contextPathTwo);
                // clear the context after it's used
                contextPathTwo = null;
            }
        }

        if (query != null) {
            target = target.queryParam("q", query);
            query = null;
        }

        if (orderby != null) {
            target = target.queryParam("orderby", orderby);
            orderby = null;
        }

        if (limit != null) {
            target = target.queryParam("limit", limit);
            limit = null;
        }

        if (skip != null) {
            target = target.queryParam("skip", skip);
            skip = null;
        }

        return target;
    }

    @Override
    public ParentApiPart getParent() {
        return null;
    }

    @Override
    public SlickClient getSlickClient() {
        return this;
    }
}
