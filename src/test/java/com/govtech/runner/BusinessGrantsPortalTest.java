package com.govtech.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
                    glue = {"com.govtech.stepdefs","com.govtech.hooks"},
                    plugin = {"pretty",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class BusinessGrantsPortalTest {


}
