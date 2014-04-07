package com.slickqa.swaggerClient.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.slickqa.client.model.Component;
import com.slickqa.client.model.Build;
import com.slickqa.client.model.Release;
import com.slickqa.client.model.Project;
import java.util.*;

public class ProjectsApi {
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

  public List<Project> get_projects (String q, String orderby, Integer limit, Integer skip) throws ApiException {
    // create path and map variables
    String path = "/projects".replaceAll("\\{format\\}","json");

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
        return (List<Project>) ApiInvoker.deserialize(response, "List", Project.class);
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
  public Project add_project (Project body) throws ApiException {
    // create path and map variables
    String path = "/projects".replaceAll("\\{format\\}","json");

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public Project set_default_build (String build_id, String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(build_id == null || release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds/setdefaultbuild/{build_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "build_id" + "\\}", apiInvoker.escapeString(build_id.toString())).replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public Build get_specific_build (String build_id, String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(build_id == null || release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds/byname/{build_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "build_id" + "\\}", apiInvoker.escapeString(build_id.toString())).replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Build) ApiInvoker.deserialize(response, "", Build.class);
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
  public Build get_default_build (String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds/default".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Build) ApiInvoker.deserialize(response, "", Build.class);
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
  public Build update_build (String build_id, String release_id, String project_id, Build body) throws ApiException {
    // verify required params are set
    if(build_id == null || release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds/{build_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "build_id" + "\\}", apiInvoker.escapeString(build_id.toString())).replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Build) ApiInvoker.deserialize(response, "", Build.class);
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
  public List<Build> delete_build (String build_id, String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(build_id == null || release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds/{build_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "build_id" + "\\}", apiInvoker.escapeString(build_id.toString())).replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (List<Build>) ApiInvoker.deserialize(response, "List", Build.class);
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
  public Component get_specific_component_for_project (String project_id, String component_id) throws ApiException {
    // verify required params are set
    if(project_id == null || component_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/components/byname/{path:component_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString())).replaceAll("\\{" + "component_id" + "\\}", apiInvoker.escapeString(component_id.toString()));

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
        return (Component) ApiInvoker.deserialize(response, "", Component.class);
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
  public Release get_specific_release_for_project (String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/byname/{release_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Release) ApiInvoker.deserialize(response, "", Release.class);
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
  public List<Build> get_builds (String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (List<Build>) ApiInvoker.deserialize(response, "List", Build.class);
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
  public Build add_build (String release_id, String project_id, Build body) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}/builds".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Build) ApiInvoker.deserialize(response, "", Build.class);
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
  public Project set_default_release_for_project (String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/setdefaultrelease/{release_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public Component update_component (String project_id, String component_id, Component body) throws ApiException {
    // verify required params are set
    if(project_id == null || component_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/components/{component_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString())).replaceAll("\\{" + "component_id" + "\\}", apiInvoker.escapeString(component_id.toString()));

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
        return (Component) ApiInvoker.deserialize(response, "", Component.class);
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
  public List<Component> delete_component (String project_id, String component_id) throws ApiException {
    // verify required params are set
    if(project_id == null || component_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/components/{component_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString())).replaceAll("\\{" + "component_id" + "\\}", apiInvoker.escapeString(component_id.toString()));

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
        return (List<Component>) ApiInvoker.deserialize(response, "List", Component.class);
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
  public Release get_default_release_for_project (String project_id) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/default".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Release) ApiInvoker.deserialize(response, "", Release.class);
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
  public Release update_release (String release_id, String project_id, Release body) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Release) ApiInvoker.deserialize(response, "", Release.class);
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
  public List<Release> delete_release (String release_id, String project_id) throws ApiException {
    // verify required params are set
    if(release_id == null || project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases/{release_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "release_id" + "\\}", apiInvoker.escapeString(release_id.toString())).replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (List<Release>) ApiInvoker.deserialize(response, "List", Release.class);
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
  public Project get_project_by_name (String project_name) throws ApiException {
    // verify required params are set
    if(project_name == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/byname/{project_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_name" + "\\}", apiInvoker.escapeString(project_name.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public Project change_project_description (String project_id, String body) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/description".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public List<Component> get_components (String project_id) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/components".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (List<Component>) ApiInvoker.deserialize(response, "List", Component.class);
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
  public Component add_component_for_project (String project_id, Component body) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/components".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Component) ApiInvoker.deserialize(response, "", Component.class);
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
  public List<Release> get_releases_for_project (String project_id) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (List<Release>) ApiInvoker.deserialize(response, "List", Release.class);
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
  public Release add_release_for_project (String project_id, Release body) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/releases".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Release) ApiInvoker.deserialize(response, "", Release.class);
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
  public Project change_project_name (String project_id, String body) throws ApiException {
    // verify required params are set
    if(project_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_id}/name".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_id" + "\\}", apiInvoker.escapeString(project_id.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public Project update_project (String project_name, Project body) throws ApiException {
    // verify required params are set
    if(project_name == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_name" + "\\}", apiInvoker.escapeString(project_name.toString()));

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
        return (Project) ApiInvoker.deserialize(response, "", Project.class);
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
  public void delete_project (String project_name) throws ApiException {
    // verify required params are set
    if(project_name == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/projects/{project_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "project_name" + "\\}", apiInvoker.escapeString(project_name.toString()));

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

