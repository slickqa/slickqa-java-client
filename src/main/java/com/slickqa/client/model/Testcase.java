package com.slickqa.client.model;

import java.util.*;

public class Testcase {
  private String requirements = null;
  private String name = null;
  private String author = null;
  private Boolean deleted = null;
  private Integer stabilityRating = null;
  private Integer importanceRating = null;
  private List<String> tags = new ArrayList<String>();
  private ComponentReference component = null;
  private FeatureReference feature = null;
  private String automationKey = null;
  private ProjectReference project = null;
  private String automationConfiguration = null;
  private List<Step> steps = new ArrayList<Step>();
  private String purpose = null;
  private Boolean automated = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String automationId = null;
  private String automationTool = null;
  private Integer automationPriority = null;
  public String getRequirements() {
    return requirements;
  }
  public void setRequirements(String requirements) {
    this.requirements = requirements;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public Boolean getDeleted() {
    return deleted;
  }
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public Integer getStabilityRating() {
    return stabilityRating;
  }
  public void setStabilityRating(Integer stabilityRating) {
    this.stabilityRating = stabilityRating;
  }

  public Integer getImportanceRating() {
    return importanceRating;
  }
  public void setImportanceRating(Integer importanceRating) {
    this.importanceRating = importanceRating;
  }

  public List<String> getTags() {
    return tags;
  }
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public ComponentReference getComponent() {
    return component;
  }
  public void setComponent(ComponentReference component) {
    this.component = component;
  }

  public FeatureReference getFeature() {
    return feature;
  }
  public void setFeature(FeatureReference feature) {
    this.feature = feature;
  }

  public String getAutomationKey() {
    return automationKey;
  }
  public void setAutomationKey(String automationKey) {
    this.automationKey = automationKey;
  }

  public ProjectReference getProject() {
    return project;
  }
  public void setProject(ProjectReference project) {
    this.project = project;
  }

  public String getAutomationConfiguration() {
    return automationConfiguration;
  }
  public void setAutomationConfiguration(String automationConfiguration) {
    this.automationConfiguration = automationConfiguration;
  }

  public List<Step> getSteps() {
    return steps;
  }
  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }

  public String getPurpose() {
    return purpose;
  }
  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public Boolean getAutomated() {
    return automated;
  }
  public void setAutomated(Boolean automated) {
    this.automated = automated;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getAutomationId() {
    return automationId;
  }
  public void setAutomationId(String automationId) {
    this.automationId = automationId;
  }

  public String getAutomationTool() {
    return automationTool;
  }
  public void setAutomationTool(String automationTool) {
    this.automationTool = automationTool;
  }

  public Integer getAutomationPriority() {
    return automationPriority;
  }
  public void setAutomationPriority(Integer automationPriority) {
    this.automationPriority = automationPriority;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Testcase {\n");
    sb.append("  requirements: ").append(requirements).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  author: ").append(author).append("\n");
    sb.append("  deleted: ").append(deleted).append("\n");
    sb.append("  stabilityRating: ").append(stabilityRating).append("\n");
    sb.append("  importanceRating: ").append(importanceRating).append("\n");
    sb.append("  tags: ").append(tags).append("\n");
    sb.append("  component: ").append(component).append("\n");
    sb.append("  feature: ").append(feature).append("\n");
    sb.append("  automationKey: ").append(automationKey).append("\n");
    sb.append("  project: ").append(project).append("\n");
    sb.append("  automationConfiguration: ").append(automationConfiguration).append("\n");
    sb.append("  steps: ").append(steps).append("\n");
    sb.append("  purpose: ").append(purpose).append("\n");
    sb.append("  automated: ").append(automated).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  automationId: ").append(automationId).append("\n");
    sb.append("  automationTool: ").append(automationTool).append("\n");
    sb.append("  automationPriority: ").append(automationPriority).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

