package com.slickqa.swaggerClient.models;

import java.util.*;
import com.slickqa.swaggerClient.models.Testrun;
import com.slickqa.swaggerClient.models.TestrunSummary;
public class TestrunGroup {
  private String grouptype = null;
  //public enum grouptypeEnum { SERIAL, PARALLEL, }; 
  /* A combined summary of all the testruns. */
  private TestrunSummary groupSummary = null;
  private String name = null;
  /* The number of milliseconds since EPOCH GMT */
  private Long created = null;
  private List<Testrun> testruns = new ArrayList<Testrun>();
  private String state = null;
  //public enum stateEnum { TO_BE_RUN, RUNNING, FINISHED, }; 
  /* A String representation of a BSON ObjectId */
  private String id = null;
  public String getGrouptype() {
    return grouptype;
  }
  public void setGrouptype(String grouptype) {
    this.grouptype = grouptype;
  }

  public TestrunSummary getGroupSummary() {
    return groupSummary;
  }
  public void setGroupSummary(TestrunSummary groupSummary) {
    this.groupSummary = groupSummary;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }

  public List<Testrun> getTestruns() {
    return testruns;
  }
  public void setTestruns(List<Testrun> testruns) {
    this.testruns = testruns;
  }

  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestrunGroup {\n");
    sb.append("  grouptype: ").append(grouptype).append("\n");
    sb.append("  groupSummary: ").append(groupSummary).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  testruns: ").append(testruns).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

