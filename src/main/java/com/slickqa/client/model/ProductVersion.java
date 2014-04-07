package com.slickqa.client.model;

public class ProductVersion {
  private String versionString = null;
  /* A String representation of a BSON ObjectId */
  private String id = null;
  private String productName = null;
  public String getVersionString() {
    return versionString;
  }
  public void setVersionString(String versionString) {
    this.versionString = versionString;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductVersion {\n");
    sb.append("  versionString: ").append(versionString).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  productName: ").append(productName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

