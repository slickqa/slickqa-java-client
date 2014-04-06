package com.slickqa.swaggerClient.models;

import java.util.*;
import com.slickqa.swaggerClient.models.Component;
import com.slickqa.swaggerClient.models.Release;
import com.slickqa.swaggerClient.models.DataDrivenProperty;
import com.slickqa.swaggerClient.models.Configuration;
public class Project {
  private List<String> automationTools = new ArrayList<String>();
  private List<Release> releases = new ArrayList<Release>();
  private List<String> tags = new ArrayList<String>();
  private List<DataDrivenProperty> dataDrivenProperties = new ArrayList<DataDrivenProperty>();
  /* The number of milliseconds since EPOCH GMT */
  private Long lastUpdated = null;
  private String name = null;
  private List<Component> components = new ArrayList<Component>();
  private Configuration configuration = null;
  private String defaultRelease = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String description = null;
  public List<String> getAutomationTools() {
    return automationTools;
  }
  public void setAutomationTools(List<String> automationTools) {
    this.automationTools = automationTools;
  }

  public List<Release> getReleases() {
    return releases;
  }
  public void setReleases(List<Release> releases) {
    this.releases = releases;
  }

  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<DataDrivenProperty> getDataDrivenProperties() {
    return dataDrivenProperties;
  }
  public void setDataDrivenProperties(List<DataDrivenProperty> dataDrivenProperties) {
    this.dataDrivenProperties = dataDrivenProperties;
  }

  public Long getLastUpdated() {
    return lastUpdated;
  }
  public void setLastUpdated(Long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public List<Component> getComponents() {
    return components;
  }
  public void setComponents(List<Component> components) {
    this.components = components;
  }

  public Configuration getConfiguration() {
    return configuration;
  }
  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  public String getDefaultRelease() {
    return defaultRelease;
  }
  public void setDefaultRelease(String defaultRelease) {
    this.defaultRelease = defaultRelease;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    sb.append("  automationTools: ").append(automationTools).append("\n");
    sb.append("  releases: ").append(releases).append("\n");
    sb.append("  tags: ").append(tags).append("\n");
    sb.append("  dataDrivenProperties: ").append(dataDrivenProperties).append("\n");
    sb.append("  lastUpdated: ").append(lastUpdated).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  components: ").append(components).append("\n");
    sb.append("  configuration: ").append(configuration).append("\n");
    sb.append("  defaultRelease: ").append(defaultRelease).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

