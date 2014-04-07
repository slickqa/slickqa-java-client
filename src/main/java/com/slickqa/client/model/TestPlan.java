package com.slickqa.client.model;

import java.util.*;

public class TestPlan {
  private String name = null;
  private ProjectReference project = null;
  private List<String> sharedWith = new ArrayList<String>();
  private String createdBy = null;
  private Boolean isprivate = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public ProjectReference getProject() {
    return project;
  }
  public void setProject(ProjectReference project) {
    this.project = project;
  }

  public List<String> getSharedWith() {
    return sharedWith;
  }
  public void setSharedWith(List<String> sharedWith) {
    this.sharedWith = sharedWith;
  }

  public String getCreatedBy() {
    return createdBy;
  }
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Boolean getIsprivate() {
    return isprivate;
  }
  public void setIsprivate(Boolean isprivate) {
    this.isprivate = isprivate;
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
    sb.append("class TestPlan {\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  project: ").append(project).append("\n");
    sb.append("  sharedWith: ").append(sharedWith).append("\n");
    sb.append("  createdBy: ").append(createdBy).append("\n");
    sb.append("  isprivate: ").append(isprivate).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

