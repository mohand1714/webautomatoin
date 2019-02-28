package pageobjects.launchpage;

import pageobjects.BasePage;

import java.io.IOException;

public class launchpage extends BasePage {


    public launchpage() throws IOException {
    }

    public launchpage goToURL() throws IOException {
        getDriver().get("www.google.com");
        return new launchpage();

    }


}
