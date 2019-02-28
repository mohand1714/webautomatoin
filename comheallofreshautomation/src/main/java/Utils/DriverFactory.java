package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pageobjects.launchpage.launchpage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {


    public static WebDriver driver;
    public static launchpage OpenBrowser;

    public WebDriver getDriver() {

        try {
            Properties p = new Properties();
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            p.load(fi);
            String browserName = p.getProperty("browser");


            switch (browserName) {

                case "firefox":

                    if (null == driver) {
                        System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        capabilities.setCapability("marionette", true);
                        driver = new FirefoxDriver();

                    }
                    break;

                case "chrome":

                    if (null == driver) {
                        System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
                        driver = new ChromeDriver();
                        driver.manage().window().fullscreen();


                    }
                    break;

            }
        } catch (Exception e) {
            System.out.println("Unable to load browser" + e.getMessage());


        } finally

        {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
OpenBrowser = PageFactory.initElements(driver, launchpage.class);

        }

        return driver;

    }
}
