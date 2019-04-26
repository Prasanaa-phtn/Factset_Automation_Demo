package stepDefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
        "html:target/cucumber-html-report","com.cucumber.listener.ExtentCucumberFormatter:output/FactSet.html"}, tags = { "@smoke" })

public class RunCukesTest {
	
}
