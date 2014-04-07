package com.slickqa.client.model;

import java.util.*;

public class Release {
  private String status = null;
  //public enum statusEnum { active, inactive, }; 
  private String defaultBuild = null;
  private String name = null;
  private List<Build> builds = new ArrayList<Build>();
  /* A String representation of a BSON ObjectId */
  private String id = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date target = null;
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public String getDefaultBuild() {
    return defaultBuild;
  }
  public void setDefaultBuild(String defaultBuild) {
    this.defaultBuild = defaultBuild;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public List<Build> getBuilds() {
    return builds;
  }
  public void setBuilds(List<Build> builds) {
    this.builds = builds;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public Date getTarget() {
    return target;
  }
  public void setTarget(Date target) {
    this.target = target;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Release {\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  defaultBuild: ").append(defaultBuild).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  builds: ").append(builds).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  target: ").append(target).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

