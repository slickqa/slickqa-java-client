package com.slickqa.client.model;

public class Step {
  private String name = null;
  private String expectedResult = null;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getExpectedResult() {
    return expectedResult;
  }
  public void setExpectedResult(String expectedResult) {
    this.expectedResult = expectedResult;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Step {\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  expectedResult: ").append(expectedResult).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

