package com.slickqa.client.model;

public class TestrunReference {
  /* A String representation of a BSON ObjectId */
  private String testrunId = null;
  private String name = null;
  public String getTestrunId() {
    return testrunId;
  }
  public void setTestrunId(String testrunId) {
    this.testrunId = testrunId;
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
    sb.append("class TestrunReference {\n");
    sb.append("  testrunId: ").append(testrunId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

