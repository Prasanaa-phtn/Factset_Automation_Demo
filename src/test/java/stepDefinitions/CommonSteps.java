package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonSteps extends AbstractStepDefinition {
    public CommonSteps() throws FileNotFoundException, IOException, ParseException {
        super();
    }
    
    @Given("^Factset application is launched$")
    public void launch() throws Exception {
        platform.launch();
    }

    @When("^user navigates to Login$")
    public void navigateToLogin() throws Exception {
        platform.navigateToLogin();
    }
    @And("^user closes the factset application$")
    public void logOut() throws Exception {
    	platform.logOut();
    }
}