package com.slickqa.swaggerClient.models;

public class ReleaseReference {
  /* A String representation of a BSON ObjectId */
  private String releaseId = null;
  private String name = null;
  public String getReleaseId() {
    return releaseId;
  }
  public void setReleaseId(String releaseId) {
    this.releaseId = releaseId;
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
    sb.append("class ReleaseReference {\n");
    sb.append("  releaseId: ").append(releaseId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

