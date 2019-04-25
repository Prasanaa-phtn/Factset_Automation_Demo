package platforms;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import helpers.ConfigurationHelper;

public class WebPortal implements FactsetPlatform {
	private WebDriver driver;
	private Properties locatorPool = null;

//	public void launch() throws Exception {
//		try {
//
//			FileReader reader = new FileReader("web_pageobjects.properties");
//			locatorPool = new Properties();
//			locatorPool.load(reader);
//			if (driver == null) {
//				System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver_70v");
//
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("start-maximized");
//				options.addArguments("disable-infobars");
//				driver = new ChromeDriver(options);
//
//				driver.manage().deleteAllCookies();
//				driver.get(ConfigurationHelper.getBaseUri());
//			}
	public void launch() throws Exception {
		try {
			FileReader reader = new FileReader("src/test/resources/pageobjects/web_pageobjects.properties");
			locatorPool = new Properties();
			locatorPool.load(reader);
			if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver_70v");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

            driver.manage().deleteAllCookies();
            driver.get(ConfigurationHelper.getBaseUri());
//				final String USERNAME = "prasanaa1";
//				final String AUTOMATE_KEY = "RGxpKLxKvJiLsC11Ty67";
//				final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//				DesiredCapabilities caps = new DesiredCapabilities();
//				caps.setCapability("browser", "Chrome");
//				caps.setCapability("browser_version", "74.0");
////				caps.setCapability("os", "Windows");
////				caps.setCapability("os_version", "10");
////				caps.setCapability("resolution", "1024x768");
//
//				driver = new RemoteWebDriver(new URL(URL), caps);
//				driver.get("http://www.google.com");
			}

		} catch (Exception e) {
		    e.printStackTrace();
			throw new Exception("Unknown error while user tries to launch the factset application");
		}
	}

	@Override
	public void logOut() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public File takeScreenshot() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void navigateToLogin() throws Exception {
		try {
			driver.findElement(By.linkText(locatorPool.getProperty("factset.home.homescreen.menu.login"))).click();
		} catch (Exception e) {
			throw new Exception("Unknown error while user tries to navigate to login");
		}
	}

	@Override
	public void login() throws Exception {
		try {
			driver.findElement(By.linkText(locatorPool.getProperty("factset.home.homescreen.menu.submitButton")))
					.click();
		} catch (Exception e) {
			throw new Exception("Unknown error while user tries to login the fatset application");
		}
	}

	@Override
	public void validateLogIn() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateLogOut() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEmailAndPassword(String email, String password) throws Exception {
		try {
			driver.findElement(By.linkText(locatorPool.getProperty("factset.home.homescreen.menu.userName")))
					.sendKeys(email);
			driver.findElement(By.linkText(locatorPool.getProperty("factset.home.homescreen.menu.password")))
					.sendKeys(password);
		} catch (Exception e) {
			throw new Exception("Unknown error while user enters email and password in login");
		}

	}

	@Override
	public void validateUnsuccessfulLogin(String error) throws Exception {
		try {
			String errormessage = driver
					.findElement(By.linkText(locatorPool.getProperty("factset.home.homescreen.menu.submitButton")))
					.getText();
			if (!errormessage.equalsIgnoreCase(error)) {
				throw new Exception("warning" + error + "message is not displayed");
			}
		} catch (Exception e) {
			throw new Exception("Unknown error while user tries to validate unseccessful login");
		}

	}
}