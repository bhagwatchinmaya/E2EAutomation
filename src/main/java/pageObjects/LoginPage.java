package pageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email=By.id("email");
	By continueEmail=By.xpath(".//div[text()='Continue with Email']");
	By password=By.id("password");
	By login=By.xpath(".//div[text()='Log In']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getContinueEmail()
	{
		return driver.findElement(continueEmail);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}	
	
}
