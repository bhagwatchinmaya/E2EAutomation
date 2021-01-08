package Utility;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	public static Logger logger = LogManager.getLogger(BrowserUtility.class);
	static String projectPath = System.getProperty("user.dir");

	public static WebDriver OpenBrowser(WebDriver driver, String url, String browserName) throws InterruptedException {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {

			logger.info("Could not able to Instatiate using the browserName " + browserName
					+ ". Please provide it as 'chrome' or 'firefox'");
			return null;
		}

		driver.manage().window().maximize();
		driver.get(url);

		return driver;

	}

	public static boolean scrollIntoView(WebDriver driver, WebElement Element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
		return true;
	}

	public static void getScreenshot(String testMethodName,WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(projectPath + "/reports/" + testMethodName + "screenshot.png"));

	}

}
