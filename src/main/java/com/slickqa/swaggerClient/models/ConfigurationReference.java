package com.slickqa.swaggerClient.models;

public class ConfigurationReference {
  /* A String representation of a BSON ObjectId */
  private String configId = null;
  private String name = null;
  private String filename = null;
  public String getConfigId() {
    return configId;
  }
  public void setConfigId(String configId) {
    this.configId = configId;
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
    sb.append("class ConfigurationReference {\n");
    sb.append("  configId: ").append(configId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  filename: ").append(filename).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

