package platforms;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.ConfigurationHelper;

public class WebPortal implements FactsetPlatform {
	public static WebDriver driver;
	private static Properties locatorPool = null;
	public void launch() throws Exception {
		try {
			FileReader reader = new FileReader("src/test/resources/pageobjects/web_pageobjects.properties");
			locatorPool = new Properties();
			locatorPool.load(reader);
			
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

            driver.manage().deleteAllCookies();
            driver.get(ConfigurationHelper.getBaseUri());
			

		} catch (Exception e) {
		    e.printStackTrace();
			throw new Exception("Unknown error while user tries to launch the factset application");
		}
	}

	@Override
	public void logOut() throws Exception {
		driver.quit();
	}

	@Override
	public File takeScreenshot() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void navigateToLogin() throws Exception {
		try {
			Thread.sleep(1000);
			driver.findElement(By.linkText("Login")).click();
		} catch (Exception e) {
			throw new Exception("Unknown error while user tries to navigate to login");
		}
	}

	@Override
	public void login() throws Exception {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(locatorPool.getProperty("factset.home.homescreen.menu.submitButton")))
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
			WebDriverWait wait= new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorPool.getProperty("factset.home.homescreen.menu.userName")))));
			driver.findElement(By.xpath(locatorPool.getProperty("factset.home.homescreen.menu.userName"))).sendKeys(email);
			driver.findElement(By.xpath(locatorPool.getProperty("factset.home.homescreen.menu.password"))).sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unknown error while user enters email and password in login");
		}

	}

	@Override
	public void validateUnsuccessfulLogin(String error) throws Exception {
		try {
			Thread.sleep(1000);
			String errormessage = driver
					.findElement(By.xpath(locatorPool.getProperty("factset.home.homescreen.menu.unsuccesssfulLoginErrorMessage")))
					.getText();
			if (!errormessage.equalsIgnoreCase(error)) {
				throw new Exception("warning" + error + "message is not displayed");
			}
		} catch (Exception e) {
			throw new Exception("Unknown error while user tries to validate unseccessful login");
		}

	}
}