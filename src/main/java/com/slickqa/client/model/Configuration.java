package com.slickqa.client.model;

public class Configuration {
  private String configurationType = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String name = null;
  private String filename = null;
  public String getConfigurationType() {
    return configurationType;
  }
  public void setConfigurationType(String configurationType) {
    this.configurationType = configurationType;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Configuration {\n");
    sb.append("  configurationType: ").append(configurationType).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  filename: ").append(filename).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

