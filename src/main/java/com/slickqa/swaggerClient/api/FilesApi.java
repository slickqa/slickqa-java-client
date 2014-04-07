package com.slickqa.swaggerClient.api;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.slickqa.client.model.StoredFile;
import java.util.*;

public class FilesApi {
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

  public StoredFile create_stored_file (StoredFile body) throws ApiException {
    // create path and map variables
    String path = "/files".replaceAll("\\{format\\}","json");

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
        return (StoredFile) ApiInvoker.deserialize(response, "", StoredFile.class);
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
  public byte[] get_file_content (String file_id, String filename) throws ApiException {
    // verify required params are set
    if(file_id == null || filename == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/files/{file_id}/content/{filename}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "file_id" + "\\}", apiInvoker.escapeString(file_id.toString())).replaceAll("\\{" + "filename" + "\\}", apiInvoker.escapeString(filename.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/octect-stream"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/octect-stream";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return response.getBytes();
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
  public StoredFile add_chunk_to_file (String file_id, byte[] body) throws ApiException {
    // verify required params are set
    if(file_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/files/{file_id}/addchunk".replaceAll("\\{format\\}","json").replaceAll("\\{" + "file_id" + "\\}", apiInvoker.escapeString(file_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/octect-stream"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/octect-stream";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (StoredFile) ApiInvoker.deserialize(response, "", StoredFile.class);
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
  public StoredFile set_file_content (String file_id, byte[] body) throws ApiException {
    // verify required params are set
    if(file_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/files/{file_id}/content".replaceAll("\\{format\\}","json").replaceAll("\\{" + "file_id" + "\\}", apiInvoker.escapeString(file_id.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/octect-stream";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (StoredFile) ApiInvoker.deserialize(response, "", StoredFile.class);
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
  public StoredFile get_stored_file (String file_id) throws ApiException {
    // verify required params are set
    if(file_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/files/{file_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "file_id" + "\\}", apiInvoker.escapeString(file_id.toString()));

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
        return (StoredFile) ApiInvoker.deserialize(response, "", StoredFile.class);
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
  public StoredFile update_stored_file (String file_id, StoredFile body) throws ApiException {
    // verify required params are set
    if(file_id == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/files/{file_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "file_id" + "\\}", apiInvoker.escapeString(file_id.toString()));

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
        return (StoredFile) ApiInvoker.deserialize(response, "", StoredFile.class);
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

