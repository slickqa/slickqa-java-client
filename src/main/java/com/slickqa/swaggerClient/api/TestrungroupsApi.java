package com.slickqa.swaggerClient.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.slickqa.swaggerClient.models.TestrunGroup;
import java.util.*;

public class TestrungroupsApi {
  String basePath = "http://localhost:9000/api";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }
  
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
  
  public String getBasePath() {
    return basePath;
  }

  public List<TestrunGroup> get_testrungroups (String q, String orderby, Integer limit, Integer skip) throws ApiException {
    // create path and map variables
    String path = "/testrungroups".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(q)))
      queryParams.put("q", String.valueOf(q));
    if(!"null".equals(String.valueOf(orderby)))
      queryParams.put("orderby", String.valueOf(orderby));
    if(!"null".equals(String.valueOf(limit)))
      queryParams.put("limit", String.valueOf(limit));
    if(!"null".equals(String.valueOf(skip)))
      queryParams.put("skip", String.valueOf(skip));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<TestrunGroup>) ApiInvoker.deserialize(response, "Array", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup add_testrungroup (TestrunGroup body) throws ApiException {
    // create path and map variables
    String path = "/testrungroups".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup remove_testrun_from_testrun_group (String testrun_id, String testrungroup_id) throws ApiException {
    // verify required params are set
    if(testrun_id == null || testrungroup_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testrungroups/{testrungroup_id}/removetestrun/{testrun_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrun_id" + "\\}", apiInvoker.escapeString(testrun_id.toString())).replaceAll("\\{" + "testrungroup_id" + "\\}", apiInvoker.escapeString(testrungroup_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup add_testrun_to_testrun_group (String testrun_id, String testrungroup_id) throws ApiException {
    // verify required params are set
    if(testrun_id == null || testrungroup_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testrungroups/{testrungroup_id}/addtestrun/{testrun_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrun_id" + "\\}", apiInvoker.escapeString(testrun_id.toString())).replaceAll("\\{" + "testrungroup_id" + "\\}", apiInvoker.escapeString(testrungroup_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup get_testrungroup_by_id (String testrungroup_id) throws ApiException {
    // verify required params are set
    if(testrungroup_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testrungroups/{testrungroup_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrungroup_id" + "\\}", apiInvoker.escapeString(testrungroup_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup update_testrungroup (String testrungroup_id, TestrunGroup body) throws ApiException {
    // verify required params are set
    if(testrungroup_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testrungroups/{testrungroup_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrungroup_id" + "\\}", apiInvoker.escapeString(testrungroup_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TestrunGroup delete_testrungroup (String testrungroup_id) throws ApiException {
    // verify required params are set
    if(testrungroup_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testrungroups/{testrungroup_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrungroup_id" + "\\}", apiInvoker.escapeString(testrungroup_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (TestrunGroup) ApiInvoker.deserialize(response, "", TestrunGroup.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  }

