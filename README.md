Slick Java Client
=================

This is a java client api for talking to the slick test manager.

Javadocs for the currently in-development version are available on the 
[build server](http://build.tcrun.org/job/slickqa-java-client/lastSuccessfulBuild/artifact/target/apidocs/index.html).


Examples
--------

Here is an example (also included in the javadocs), of how to get a list of 
projects out of slick:

    SlickClient slick = SlickClientFactory.getSlickClient("http://localhost/slick");
    List&lt;Project&gt; projects = null;
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
