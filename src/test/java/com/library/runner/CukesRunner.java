package com.library.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

                plugin = {
                        "pretty",
                        "html:target/cucumber-report.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                        "json:target/cucumber.json",
                        "html:target/cucumber/report.html",
                        "junit:target/junit/junit-report.xml",
                },
                features = "src/test/resources/features",
                glue = "com/library/step_definition",
                dryRun = false,
                tags = "@us03",
               publish = false

)

public class CukesRunner {
}
