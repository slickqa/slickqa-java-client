package com.slickqa.swaggerClient.models;

import java.util.*;
public class DataDrivenProperty {
  private Boolean requirement = null;
  private String name = null;
  private List<String> standardValues = new ArrayList<String>();
  public Boolean getRequirement() {
    return requirement;
  }
  public void setRequirement(Boolean requirement) {
    this.requirement = requirement;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public List<String> getStandardValues() {
    return standardValues;
  }
  public void setStandardValues(List<String> standardValues) {
    this.standardValues = standardValues;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataDrivenProperty {\n");
    sb.append("  requirement: ").append(requirement).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  standardValues: ").append(standardValues).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

