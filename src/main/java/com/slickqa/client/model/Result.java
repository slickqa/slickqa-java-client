package com.slickqa.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Result {
  private List<StoredFile> files = new ArrayList<StoredFile>();
  private String status = null;
  private String hostname = null;
  private List<LogEntry> log = new ArrayList<LogEntry>();
  /* The number of milliseconds since EPOCH GMT */
  private Date started = null;
  private ComponentReference component = null;
  private List<ConfigurationOverride> configurationOverride = new ArrayList<ConfigurationOverride>();
  /* The number of milliseconds since EPOCH GMT */
  private Date recorded = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date finished = null;
  private ProjectReference project = null;
  private String reason = null;
  private BuildReference build = null;
  private ReleaseReference release = null;
  private String runstatus = null;
  private TestcaseReference testcase = null;
  private ConfigurationReference config = null;
  private TestrunReference testrun = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private Integer runlength = null;
  private List<ResultReference> history = new ArrayList<ResultReference>();
  private List<Link> links = new ArrayList<>();
  private HashMap<String, String> attributes = new HashMap<String, String>();

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public List<StoredFile> getFiles() {
    return files;
  }
  public void setFiles(List<StoredFile> files) {
    this.files = files;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public String getHostname() {
    return hostname;
  }
  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public List<LogEntry> getLog() {
    return log;
  }
  public void setLog(List<LogEntry> log) {
    this.log = log;
  }

  public Date getStarted() {
    return started;
  }
  public void setStarted(Date started) {
    this.started = started;
  }

  public ComponentReference getComponent() {
    return component;
  }
  public void setComponent(ComponentReference component) {
    this.component = component;
  }

  public List<ConfigurationOverride> getConfigurationOverride() {
    return configurationOverride;
  }
  public void setConfigurationOverride(List<ConfigurationOverride> configurationOverride) {
    this.configurationOverride = configurationOverride;
  }

  public Date getRecorded() {
    return recorded;
  }
  public void setRecorded(Date recorded) {
    this.recorded = recorded;
  }

  public Date getFinished() {
    return finished;
  }
  public void setFinished(Date finished) {
    this.finished = finished;
  }

  public ProjectReference getProject() {
    return project;
  }
  public void setProject(ProjectReference project) {
    this.project = project;
  }

  public String getReason() {
    return reason;
  }
  public void setReason(String reason) {
    this.reason = reason;
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

  public String getRunstatus() {
    return runstatus;
  }
  public void setRunstatus(String runstatus) {
    this.runstatus = runstatus;
  }

  public TestcaseReference getTestcase() {
    return testcase;
  }
  public void setTestcase(TestcaseReference testcase) {
    this.testcase = testcase;
  }

  public ConfigurationReference getConfig() {
    return config;
  }
  public void setConfig(ConfigurationReference config) {
    this.config = config;
  }

  public TestrunReference getTestrun() {
    return testrun;
  }
  public void setTestrun(TestrunReference testrun) {
    this.testrun = testrun;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public Integer getRunlength() {
    return runlength;
  }
  public void setRunlength(Integer runlength) {
    this.runlength = runlength;
  }

  public List<ResultReference> getHistory() {
    return history;
  }
  public void setHistory(List<ResultReference> history) {
    this.history = history;
  }

  public HashMap<String, String> getAttributes() { return attributes; }
  public void setAttributes(HashMap<String, String> attributes) { this.attributes = attributes; }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    sb.append("  files: ").append(files).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  hostname: ").append(hostname).append("\n");
    sb.append("  log: ").append(log).append("\n");
    sb.append("  started: ").append(started).append("\n");
    sb.append("  component: ").append(component).append("\n");
    sb.append("  configurationOverride: ").append(configurationOverride).append("\n");
    sb.append("  recorded: ").append(recorded).append("\n");
    sb.append("  finished: ").append(finished).append("\n");
    sb.append("  project: ").append(project).append("\n");
    sb.append("  reason: ").append(reason).append("\n");
    sb.append("  build: ").append(build).append("\n");
    sb.append("  release: ").append(release).append("\n");
    sb.append("  runstatus: ").append(runstatus).append("\n");
    sb.append("  testcase: ").append(testcase).append("\n");
    sb.append("  config: ").append(config).append("\n");
    sb.append("  testrun: ").append(testrun).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  runlength: ").append(runlength).append("\n");
    sb.append("  history: ").append(history).append("\n");
    sb.append("  links: ").append(links).append("\n");
    sb.append("  attributes: ").append(attributes).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

