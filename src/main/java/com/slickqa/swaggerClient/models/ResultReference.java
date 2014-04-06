package com.slickqa.swaggerClient.models;

import com.slickqa.swaggerClient.models.BuildReference;
public class ResultReference {
  private String status = null;
  /* A String representation of a BSON ObjectId */
  private String resultId = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long recorded = null;
  private BuildReference build = null;
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public String getResultId() {
    return resultId;
  }
  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public Long getRecorded() {
    return recorded;
  }
  public void setRecorded(Long recorded) {
    this.recorded = recorded;
  }

  public BuildReference getBuild() {
    return build;
  }
  public void setBuild(BuildReference build) {
    this.build = build;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultReference {\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  resultId: ").append(resultId).append("\n");
    sb.append("  recorded: ").append(recorded).append("\n");
    sb.append("  build: ").append(build).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

