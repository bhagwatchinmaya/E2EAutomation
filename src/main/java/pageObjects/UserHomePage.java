package pageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHomePage {

	
	public WebDriver driver;
	
	By searchInputBox=By.xpath(".//input[@placeholder='Where to?']");
	By searchButton=By.xpath(".//span[text()='Search']");
	By routePlanner=By.xpath(".//*[@href='/plan']");
	
	public UserHomePage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchInputBox);
	}
	
	public WebElement getSearchButton()
	{
		return driver.findElement(searchButton);
	}
	
	public WebElement getRoutePlanner()
	{
		return driver.findElement(routePlanner);
	}
}
