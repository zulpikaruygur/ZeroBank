package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import com.zerobank.utilities.ConfigurationReader;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "html:target/default-html-reports"},
        glue = "src/test/java/com/zerobank/stepDefinitions", strict = true
)
public class CukesRunner {
}
