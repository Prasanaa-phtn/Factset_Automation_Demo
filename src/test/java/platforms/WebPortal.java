package platforms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import exceptions.HigiException;
import helpers.ConfigurationHelper;

public class WebPortal implements FactsetPlatform {
    private WebDriver driver;
    public void launch() throws HigiException {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver_70v");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

            driver.manage().deleteAllCookies();
            driver.get(ConfigurationHelper.getWebPortalEnvironment().getBaseUri());
        }
    }
}