package com.slickqa.swaggerClient.models;

public class ConfigurationOverride {
  private Boolean isRequirement = null;
  private String key = null;
  private String value = null;
  public Boolean getIsRequirement() {
    return isRequirement;
  }
  public void setIsRequirement(Boolean isRequirement) {
    this.isRequirement = isRequirement;
  }

  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationOverride {\n");
    sb.append("  isRequirement: ").append(isRequirement).append("\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

