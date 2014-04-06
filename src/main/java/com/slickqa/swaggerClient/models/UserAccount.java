package com.slickqa.swaggerClient.models;

public class UserAccount {
  private String openid = null;
  private String short_name = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long last_login = null;
  private String full_name = null;
  private String email = null;
  public String getOpenid() {
    return openid;
  }
  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getShort_name() {
    return short_name;
  }
  public void setShort_name(String short_name) {
    this.short_name = short_name;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public Long getLast_login() {
    return last_login;
  }
  public void setLast_login(Long last_login) {
    this.last_login = last_login;
  }

  public String getFull_name() {
    return full_name;
  }
  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccount {\n");
    sb.append("  openid: ").append(openid).append("\n");
    sb.append("  short_name: ").append(short_name).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  last_login: ").append(last_login).append("\n");
    sb.append("  full_name: ").append(full_name).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

