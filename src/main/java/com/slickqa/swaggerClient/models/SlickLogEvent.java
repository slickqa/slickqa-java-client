package com.slickqa.swaggerClient.models;

public class SlickLogEvent {
  private String name = null;
  private String eventType = null;
  //public enum eventTypeEnum { CREATED, DELETED, MODIFIED, MESSAGE, }; 
  private String targetid = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long occurred = null;
  private String user = null;
  private String message = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String fieldType = null;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEventType() {
    return eventType;
  }
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getTargetid() {
    return targetid;
  }
  public void setTargetid(String targetid) {
    this.targetid = targetid;
  }

  public Long getOccurred() {
    return occurred;
  }
  public void setOccurred(Long occurred) {
    this.occurred = occurred;
  }

  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getFieldType() {
    return fieldType;
  }
  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlickLogEvent {\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  eventType: ").append(eventType).append("\n");
    sb.append("  targetid: ").append(targetid).append("\n");
    sb.append("  occurred: ").append(occurred).append("\n");
    sb.append("  user: ").append(user).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  fieldType: ").append(fieldType).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

