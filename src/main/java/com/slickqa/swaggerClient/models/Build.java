package com.slickqa.swaggerClient.models;

public class Build {
  private String description = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long built = null;
  private String name = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public Long getBuilt() {
    return built;
  }
  public void setBuilt(Long built) {
    this.built = built;
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
    sb.append("class Build {\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  built: ").append(built).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

