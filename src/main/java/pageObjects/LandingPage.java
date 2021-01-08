package pageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	By acceptCookie=By.xpath(".//div[text()='Accept All']");
	By login=By.xpath("(.//span[text()='Sign up or log in'])[1]");
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getAcceptCookie()
	{
		return driver.findElement(acceptCookie);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(login);
	}	
	
}
