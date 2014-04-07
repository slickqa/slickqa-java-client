package com.slickqa.client.model;

public class TestcaseReference {
  private String automationId = null;
  private String automationKey = null;
  /* A String representation of a BSON ObjectId */
  private String testcaseId = null;
  private String automationTool = null;
  private String name = null;
  public String getAutomationId() {
    return automationId;
  }
  public void setAutomationId(String automationId) {
    this.automationId = automationId;
  }

  public String getAutomationKey() {
    return automationKey;
  }
  public void setAutomationKey(String automationKey) {
    this.automationKey = automationKey;
  }

  public String getTestcaseId() {
    return testcaseId;
  }
  public void setTestcaseId(String testcaseId) {
    this.testcaseId = testcaseId;
  }

  public String getAutomationTool() {
    return automationTool;
  }
  public void setAutomationTool(String automationTool) {
    this.automationTool = automationTool;
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
    sb.append("class TestcaseReference {\n");
    sb.append("  automationId: ").append(automationId).append("\n");
    sb.append("  automationKey: ").append(automationKey).append("\n");
    sb.append("  testcaseId: ").append(testcaseId).append("\n");
    sb.append("  automationTool: ").append(automationTool).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

