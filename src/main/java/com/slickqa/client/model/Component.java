package com.slickqa.client.model;

import java.util.*;

public class Component {
  private String code = null;
  private List<Feature> features = new ArrayList<Feature>();
  private String description = null;
  private String name = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public List<Feature> getFeatures() {
    return features;
  }
  public void setFeatures(List<Feature> features) {
    this.features = features;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Component {\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  features: ").append(features).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

