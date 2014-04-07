package com.slickqa.client.model;

public class ResultsByStatus {
  private Integer SKIPPED = null;
  private Integer BROKEN_TEST = null;
  private Integer NO_RESULT = null;
  private Integer NOT_TESTED = null;
  private Integer PASS = null;
  private Integer FAIL = null;
  public Integer getSKIPPED() {
    return SKIPPED;
  }
  public void setSKIPPED(Integer SKIPPED) {
    this.SKIPPED = SKIPPED;
  }

  public Integer getBROKEN_TEST() {
    return BROKEN_TEST;
  }
  public void setBROKEN_TEST(Integer BROKEN_TEST) {
    this.BROKEN_TEST = BROKEN_TEST;
  }

  public Integer getNO_RESULT() {
    return NO_RESULT;
  }
  public void setNO_RESULT(Integer NO_RESULT) {
    this.NO_RESULT = NO_RESULT;
  }

  public Integer getNOT_TESTED() {
    return NOT_TESTED;
  }
  public void setNOT_TESTED(Integer NOT_TESTED) {
    this.NOT_TESTED = NOT_TESTED;
  }

  public Integer getPASS() {
    return PASS;
  }
  public void setPASS(Integer PASS) {
    this.PASS = PASS;
  }

  public Integer getFAIL() {
    return FAIL;
  }
  public void setFAIL(Integer FAIL) {
    this.FAIL = FAIL;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultsByStatus {\n");
    sb.append("  SKIPPED: ").append(SKIPPED).append("\n");
    sb.append("  BROKEN_TEST: ").append(BROKEN_TEST).append("\n");
    sb.append("  NO_RESULT: ").append(NO_RESULT).append("\n");
    sb.append("  NOT_TESTED: ").append(NOT_TESTED).append("\n");
    sb.append("  PASS: ").append(PASS).append("\n");
    sb.append("  FAIL: ").append(FAIL).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

