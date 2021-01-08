package Academy;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.PropertiesFileReader;
import pageObjects.UserHomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.RoutePlannerPage;

public class TestLauncher{
	
	public static WebDriver driver;
	FileInputStream fis;
	public static Logger log = LogManager.getLogger(TestLauncher.class);
	public static Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	RoutePlannerPage routePlannerPage;
	PropertiesFileReader obj = new PropertiesFileReader();
	Properties properties;

	@BeforeTest
	public void launchTestEnvironment() throws IOException, InterruptedException {
		log.info("Starting Test case openBrowser");
		prop = obj.getProperty();
		driver = Utility.BrowserUtility.OpenBrowser(driver, prop.getProperty("url"), prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Test case openBrowser completed");
	}

	@Test(priority = 1)
	public void validateTestApplication() throws InterruptedException {
		log.info("Starting Test case validateTestApplication");
		String expectedTitle = prop.getProperty("expectedTitle");
		String actualTitle = driver.getTitle();
		Assert.assertTrue("Expected Title do not match : Test Case failed", expectedTitle.equals(actualTitle));
		log.info("Test case validateTestApplication completed");

	}

	@Test(priority = 2)
	public void launchLoginPage() {
		log.info("Starting Test case launchLoginPage");
		landingPage = new LandingPage(driver);
		landingPage.getAcceptCookie().click();
		landingPage.getLoginButton().click();
		log.info("Test case launchLoginPage completed");

	}
	
	@Test(priority = 3)
	public void testLogin() {
		log.info("Starting Test case testLogin");
		loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(prop.getProperty("username"));
		loginPage.getContinueEmail().click();
		loginPage.getPassword().sendKeys(prop.getProperty("password"));
		loginPage.getLogin().click();
		log.info("Test case testLogin completed");
	}
	
	@Test(priority = 4)
	public void naviagateToRoutePlannerPage(){
		log.info("Starting Test case naviagateToRoutePlannerPage");
		UserHomePage userHomePage = new UserHomePage(driver);
		userHomePage.getRoutePlanner().click();
		log.info("Test case naviagateToRoutePlannerPage completed");
	}
	
	@Test(priority = 5)
	public void setDestinationPoint(){
		log.info("Starting Test case setDestinationPoint");
		routePlannerPage = new RoutePlannerPage(driver);
		routePlannerPage.getDestinationPointMap(prop.getProperty("destination")).click();
		routePlannerPage.getSetDestination().click();
		log.info("Test case setDestinationPoint completed");
	}
	
	@Test(priority = 6)
	public void setStartPoint(){
		log.info("Starting Test case setStartPoint");
		routePlannerPage.getSetStart(prop.getProperty("startPoint")).click();
		routePlannerPage.getSetStartHere().click();
		log.info("Test case setStartPoint completed");
	}
	
	@Test(priority = 7)
	public void setSaveTour(){
		log.info("Starting Test case setSaveTour");
		routePlannerPage.getSaveTour().click();
		routePlannerPage.getClickPopUp().click();
		routePlannerPage.getClickAnotherPopUp().click();
		log.info("Test case setSaveTour completed");
	}
	
	@Test(priority = 8)
	public void userLogout(){
		log.info("Starting Test case userLogout");
		routePlannerPage.getActionMore().click();
		routePlannerPage.getLogout().click();
		log.info("Test case userLogout completed");
	}

	@AfterTest
	public void teardown() {
		log.info("Starting teardown");
		driver.close();
		driver = null;
		log.info("Teardown completed");

	}

}
