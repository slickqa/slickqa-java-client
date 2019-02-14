Slick Java Client
=================

This is a java client api for talking to the slick test manager.

Javadocs for the currently in-development version are available on the 
[build server](http://build.tcrun.org/job/slickqa-java-client/lastSuccessfulBuild/artifact/target/apidocs/index.html).
You can also see unit test results and code coverage results on the [build server](http://build.tcrun.org/job/slickqa-java-client/).

Examples
--------

Here is an example (also included in the javadocs), of how to get a list of 
projects out of slick:

```java
SlickClient slick = SlickClientFactory.getSlickClient("http://localhost/slick/api");
List<Project> projects = null;
try {
    projects = slick.projects().getList();
} catch(SlickError e) {
    System.err.println("Error retrieving list of projects from slick: " + e.getMessage());
}
if (projects != null) {
    System.out.println("Projects in slick:");
    System.out.println("------------------");
    for(Project project : projects) {
        System.out.println(project.toString());
    }
} else {
    System.out.println("Nothing to see here, move along.");
} 
```

Development
-----------
The version should always end in `-SNAPSHOT`.  The build system changes the `-SNAPSHOT` to the current
build number (assigned by jenkins at build time).  For build information see 
https://build.slickqa.com/blue/organizations/jenkins/slickqa-java-client/activity

