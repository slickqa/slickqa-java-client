package com.slickqa.client.model;

import java.util.*;

public class Testrun {
  /* The number of milliseconds since EPOCH GMT */
  private Date runStarted = null;
  private List<StoredFile> files = new ArrayList<StoredFile>();
  private ConfigurationReference runtimeOptions = null;
  /* A String representation of a BSON ObjectId */
  private String testplanId = null;
  private String name = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date dateCreated = null;
  private ProjectReference project = null;
  private String state = null;
  private String info = null;
  private BuildReference build = null;
  private ReleaseReference release = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date runFinished = null;
  private TestrunSummary summary = null;
  private ConfigurationReference config = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private TestPlan testplan = null;

  private List<Link> links = new ArrayList<>();

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public Date getRunStarted() {
    return runStarted;
  }
  public void setRunStarted(Date runStarted) {
    this.runStarted = runStarted;
  }

  public List<StoredFile> getFiles() {
    return files;
  }
  public void setFiles(List<StoredFile> files) {
    this.files = files;
  }

  public ConfigurationReference getRuntimeOptions() {
    return runtimeOptions;
  }
  public void setRuntimeOptions(ConfigurationReference runtimeOptions) {
    this.runtimeOptions = runtimeOptions;
  }

  public String getTestplanId() {
    return testplanId;
  }
  public void setTestplanId(String testplanId) {
    this.testplanId = testplanId;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Date getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public ProjectReference getProject() {
    return project;
  }
  public void setProject(ProjectReference project) {
    this.project = project;
  }

  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  public String getInfo() {
    return info;
  }
  public void setInfo(String info) {
    this.info = info;
  }

  public BuildReference getBuild() {
    return build;
  }
  public void setBuild(BuildReference build) {
    this.build = build;
  }

  public ReleaseReference getRelease() {
    return release;
  }
  public void setRelease(ReleaseReference release) {
    this.release = release;
  }

  public Date getRunFinished() {
    return runFinished;
  }
  public void setRunFinished(Date runFinished) {
    this.runFinished = runFinished;
  }

  public TestrunSummary getSummary() {
    return summary;
  }
  public void setSummary(TestrunSummary summary) {
    this.summary = summary;
  }

  public ConfigurationReference getConfig() {
    return config;
  }
  public void setConfig(ConfigurationReference config) {
    this.config = config;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public TestPlan getTestplan() {
    return testplan;
  }
  public void setTestplan(TestPlan testplan) {
    this.testplan = testplan;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Testrun {\n");
    sb.append("  runStarted: ").append(runStarted).append("\n");
    sb.append("  files: ").append(files).append("\n");
    sb.append("  runtimeOptions: ").append(runtimeOptions).append("\n");
    sb.append("  testplanId: ").append(testplanId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  dateCreated: ").append(dateCreated).append("\n");
    sb.append("  project: ").append(project).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  info: ").append(info).append("\n");
    sb.append("  build: ").append(build).append("\n");
    sb.append("  release: ").append(release).append("\n");
    sb.append("  runFinished: ").append(runFinished).append("\n");
    sb.append("  summary: ").append(summary).append("\n");
    sb.append("  config: ").append(config).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  testplan: ").append(testplan).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

