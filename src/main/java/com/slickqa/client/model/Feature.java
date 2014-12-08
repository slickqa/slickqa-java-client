package com.slickqa.client.model;

public class Feature {
  private String description = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String name = null;
  private StoredFile img = null;
  private String imgUrl = null;

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public StoredFile getImg() {
    return img;
  }
  public void setImg(StoredFile img) {
    this.img = img;
  }
  public String getImgUrl() {
    return imgUrl;
  }
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  img: ").append(img).append("\n");
    sb.append("  imgUrl: ").append(imgUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

