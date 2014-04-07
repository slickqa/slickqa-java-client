package com.slickqa.client.model;

import java.util.Date;

public class StoredFile {
  private String mimetype = null;
  private Integer chunkSize = null;
  private String filename = null;
  private Long length = null;
  /* The number of milliseconds since EPOCH GMT */
  private Date uploadDate = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String md5 = null;
  public String getMimetype() {
    return mimetype;
  }
  public void setMimetype(String mimetype) {
    this.mimetype = mimetype;
  }

  public Integer getChunkSize() {
    return chunkSize;
  }
  public void setChunkSize(Integer chunkSize) {
    this.chunkSize = chunkSize;
  }

  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  public Long getLength() {
    return length;
  }
  public void setLength(Long length) {
    this.length = length;
  }

  public Date getUploadDate() {
    return uploadDate;
  }
  public void setUploadDate(Date uploadDate) {
    this.uploadDate = uploadDate;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getMd5() {
    return md5;
  }
  public void setMd5(String md5) {
    this.md5 = md5;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoredFile {\n");
    sb.append("  mimetype: ").append(mimetype).append("\n");
    sb.append("  chunkSize: ").append(chunkSize).append("\n");
    sb.append("  filename: ").append(filename).append("\n");
    sb.append("  length: ").append(length).append("\n");
    sb.append("  uploadDate: ").append(uploadDate).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  md5: ").append(md5).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

