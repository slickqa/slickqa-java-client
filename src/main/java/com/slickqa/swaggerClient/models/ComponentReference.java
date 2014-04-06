package com.slickqa.swaggerClient.models;

public class ComponentReference {
  private String code = null;
  private String name = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
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
    sb.append("class ComponentReference {\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

