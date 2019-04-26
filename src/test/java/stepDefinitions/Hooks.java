package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.*;

public class Hooks {



    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        DataHelper.setCurrentScenario(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
    	PlatformHelper.getCurrentPlatform().logOut();
    }
}
