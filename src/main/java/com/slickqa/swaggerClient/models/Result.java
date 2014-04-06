package com.slickqa.swaggerClient.models;

import java.util.*;
import com.slickqa.swaggerClient.models.TestrunReference;
import com.slickqa.swaggerClient.models.ComponentReference;
import com.slickqa.swaggerClient.models.ConfigurationReference;
import com.slickqa.swaggerClient.models.ReleaseReference;
import com.slickqa.swaggerClient.models.StoredFile;
import com.slickqa.swaggerClient.models.LogEntry;
import com.slickqa.swaggerClient.models.TestcaseReference;
import com.slickqa.swaggerClient.models.ResultReference;
import com.slickqa.swaggerClient.models.BuildReference;
import com.slickqa.swaggerClient.models.ConfigurationOverride;
import com.slickqa.swaggerClient.models.ProjectReference;
public class Result {
  private List<StoredFile> files = new ArrayList<StoredFile>();
  private String status = null;
  private String hostname = null;
  private List<LogEntry> log = new ArrayList<LogEntry>();
  /* The number of milliseconds since EPOCH GMT */
  private Long started = null;
  private ComponentReference component = null;
  private List<ConfigurationOverride> configurationOverride = new ArrayList<ConfigurationOverride>();
  /* The number of milliseconds since EPOCH GMT */
  private Long recorded = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long finished = null;
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

  public Long getStarted() {
    return started;
  }
  public void setStarted(Long started) {
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

  public Long getRecorded() {
    return recorded;
  }
  public void setRecorded(Long recorded) {
    this.recorded = recorded;
  }

  public Long getFinished() {
    return finished;
  }
  public void setFinished(Long finished) {
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
    sb.append("}\n");
    return sb.toString();
  }
}

