package Steps.LaunchSteps;

import Utils.DriverFactory;
import cucumber.api.java.en.Given;

public class launchstep extends DriverFactory {

    @Given("^I go to HelloFresh$")
    public void iGoToHelloFresh() throws Throwable {
        OpenBrowser.goToURL();

    }
}
