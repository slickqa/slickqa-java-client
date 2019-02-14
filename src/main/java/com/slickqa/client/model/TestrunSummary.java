package com.slickqa.client.model;

import java.util.ArrayList;
import java.util.List;

public class TestrunSummary {
  private Integer totalTime = null;
  private ResultsByStatus resultsByStatus = null;
  private Integer total = null;
  private List<String> statusListOrdered = new ArrayList<String>();
  public Integer getTotalTime() {
    return totalTime;
  }
  public void setTotalTime(Integer totalTime) {
    this.totalTime = totalTime;
  }

  public ResultsByStatus getResultsByStatus() {
    return resultsByStatus;
  }
  public void setResultsByStatus(ResultsByStatus resultsByStatus) {
    this.resultsByStatus = resultsByStatus;
  }

  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<String> getStatusListOrdered() {
    return statusListOrdered;
  }
  public void setStatusListOrdered(List<String> statusListOrdered) {
    this.statusListOrdered = statusListOrdered;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestrunSummary {\n");
    sb.append("  totalTime: ").append(totalTime).append("\n");
    sb.append("  resultsByStatus: ").append(resultsByStatus).append("\n");
    sb.append("  total: ").append(total).append("\n");
    sb.append("  statusListOrdered: ").append(statusListOrdered).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

