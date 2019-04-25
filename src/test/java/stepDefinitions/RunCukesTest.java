package stepDefinitions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty:target/cucumber-pretty.txt",
        "html:target/cucumber-html-report", "json:target/cucumber.json",
        "com.cucumber.listener.ExtentCucumberFormatter:output/HigiQAAutomationReport.html" }, tags = { "@smoke" })

public class RunCukesTest {

    @AfterClass
    public static void teardown() {

            Reporter.setTestRunnerOutput("<a href='kui.log'>kui</a>" + "<a href='weblogfile.log'>weblog</a>" + "<a href='android.log'>android</a>" +"<a href='ios.log'>ios</a>"
                    + "<a href='mockFileLog.log'>MockLogFile</a>");
      

        Reporter.loadXMLConfig(new File("src/test/resources/testdata/extent-config.xml"));
    }
}
