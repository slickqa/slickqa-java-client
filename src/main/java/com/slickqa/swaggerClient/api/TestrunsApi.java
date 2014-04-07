package com.slickqa.swaggerClient.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.slickqa.client.model.Testrun;
import java.util.*;

public class TestrunsApi {
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

  public List<Testrun> get_testruns (String q, String orderby, Integer limit, Integer skip) throws ApiException {
    // create path and map variables
    String path = "/testruns".replaceAll("\\{format\\}","json");

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
        return (List<Testrun>) ApiInvoker.deserialize(response, "Array", Testrun.class);
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
  public Testrun add_testrun (Testrun body) throws ApiException {
    // create path and map variables
    String path = "/testruns".replaceAll("\\{format\\}","json");

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
        return (Testrun) ApiInvoker.deserialize(response, "", Testrun.class);
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
  public Testrun get_testrun_by_id (String testrun_id) throws ApiException {
    // verify required params are set
    if(testrun_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testruns/{testrun_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrun_id" + "\\}", apiInvoker.escapeString(testrun_id.toString()));

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
        return (Testrun) ApiInvoker.deserialize(response, "", Testrun.class);
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
  public Testrun update_testrun (String testrun_id, Testrun body) throws ApiException {
    // verify required params are set
    if(testrun_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testruns/{testrun_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrun_id" + "\\}", apiInvoker.escapeString(testrun_id.toString()));

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
        return (Testrun) ApiInvoker.deserialize(response, "", Testrun.class);
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
  public Testrun delete_testrun (String testrun_id) throws ApiException {
    // verify required params are set
    if(testrun_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/testruns/{testrun_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "testrun_id" + "\\}", apiInvoker.escapeString(testrun_id.toString()));

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
        return (Testrun) ApiInvoker.deserialize(response, "", Testrun.class);
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

