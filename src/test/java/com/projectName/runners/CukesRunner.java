package com.projectName.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/json-report.json"
        },
        features = "src/test/resources/features",
        glue = "com/projectName/step_definitions",
        dryRun = false,
        tags = "",
        publish = true
)

public class CukesRunner {
}
