package com.slickqa.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class LogEntry {
  private String exceptionClassName = null;
  private String level = null;
  private String exceptionMessage = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date entryTime = null;
  private String loggerName = null;
  private List<String> exceptionStackTrace = new ArrayList<String>();
  private String message = null;
  public String getExceptionClassName() {
    return exceptionClassName;
  }
  public void setExceptionClassName(String exceptionClassName) {
    this.exceptionClassName = exceptionClassName;
  }

  public String getLevel() {
    return level;
  }
  public void setLevel(String level) {
    this.level = level;
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  public Date getEntryTime() {
    return entryTime;
  }
  public void setEntryTime(Date entryTime) {
    this.entryTime = entryTime;
  }

  public String getLoggerName() {
    return loggerName;
  }
  public void setLoggerName(String loggerName) {
    this.loggerName = loggerName;
  }

  public List<String> getExceptionStackTrace() {
    return exceptionStackTrace;
  }
  public void setExceptionStackTrace(List<String> exceptionStackTrace) {
    this.exceptionStackTrace = exceptionStackTrace;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogEntry {\n");
    sb.append("  exceptionClassName: ").append(exceptionClassName).append("\n");
    sb.append("  level: ").append(level).append("\n");
    sb.append("  exceptionMessage: ").append(exceptionMessage).append("\n");
    sb.append("  entryTime: ").append(entryTime).append("\n");
    sb.append("  loggerName: ").append(loggerName).append("\n");
    sb.append("  exceptionStackTrace: ").append(exceptionStackTrace).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

