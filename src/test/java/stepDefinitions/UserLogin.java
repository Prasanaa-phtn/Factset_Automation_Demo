package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class UserLogin extends AbstractStepDefinition {

    public UserLogin() throws FileNotFoundException, IOException, ParseException {
        super();
    }

    @When("user enters email (.*) and password (.*)")
    public void enterEmailAndPassword(String email, String password) throws Exception {
        platform.enterEmailAndPassword(email, password);
    }

    @When("user validates the error message (.*)")
    public void validateUnsuccessfulLogin(String errormessage) throws Exception {
        platform.validateUnsuccessfulLogin(errormessage);
    }

}