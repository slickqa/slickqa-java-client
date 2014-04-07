package com.slickqa.client.model;

public class BuildReference {
  /* A String representation of a BSON ObjectId */
  private String buildId = null;
  private String name = null;
  public String getBuildId() {
    return buildId;
  }
  public void setBuildId(String buildId) {
    this.buildId = buildId;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildReference {\n");
    sb.append("  buildId: ").append(buildId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

