package com.library.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/library/step_definition",
        features = "@target/rerun.txt"

)
public class FailedTestRunner {
}
