package com.slickqa.swaggerClient.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.slickqa.swaggerClient.models.Configuration;
import java.util.*;

public class ConfigurationsApi {
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

  public List<Configuration> get_all_matching_configurations (String q, String orderby, Integer limit, Integer skip) throws ApiException {
    // create path and map variables
    String path = "/configurations".replaceAll("\\{format\\}","json");

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
        return (List<Configuration>) ApiInvoker.deserialize(response, "Array", Configuration.class);
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
  public Configuration create_configuration (Configuration body) throws ApiException {
    // create path and map variables
    String path = "/configurations".replaceAll("\\{format\\}","json");

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
        return (Configuration) ApiInvoker.deserialize(response, "", Configuration.class);
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
  public Configuration get_configuration (String configuration_id) throws ApiException {
    // verify required params are set
    if(configuration_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/configurations/{configuration_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "configuration_id" + "\\}", apiInvoker.escapeString(configuration_id.toString()));

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
        return (Configuration) ApiInvoker.deserialize(response, "", Configuration.class);
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
  public void update_configuration (String configuration_id, Configuration body) throws ApiException {
    // verify required params are set
    if(configuration_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/configurations/{configuration_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "configuration_id" + "\\}", apiInvoker.escapeString(configuration_id.toString()));

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
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public void delete_configuration (String configuration_id) throws ApiException {
    // verify required params are set
    if(configuration_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/configurations/{configuration_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "configuration_id" + "\\}", apiInvoker.escapeString(configuration_id.toString()));

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
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  }

