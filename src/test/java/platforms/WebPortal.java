package platforms;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import helpers.ConfigurationHelper;

public class WebPortal implements FactsetPlatform {
    private WebDriver driver;
    public void launch() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver_70v");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

            driver.manage().deleteAllCookies();
            driver.get(ConfigurationHelper.getBaseUri());
        }
    }
    @Override
    public void logOut() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public File takeScreenshot() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void navigateToLogin() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void login(String username, String password) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void validateLogIn() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void validateLogOut() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void enterEmailAndPassword(String email, String password) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void validateUnsuccessfulLogin(String error) {
        // TODO Auto-generated method stub
        
    }
}