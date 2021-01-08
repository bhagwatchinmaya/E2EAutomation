package pageObjects;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoutePlannerPage {

	public WebDriver driver;
	By staringPoint=By.xpath(".//*[text()='Enter Starting Point']");
	By endingPoint=By.xpath(".//*[text()='Enter Destination']");
	By searchPlace=By.xpath(".//*[@placeholder='Search For Place Or Address']");
	By setDestination=By.xpath(".//*[text()='Set as Destination']");
	By setStartHere=By.xpath(".//*[text()='Start Here']//../..");
	By saveTour=By.xpath(".//*[text()='Save Tour']");
	By clickPopUp=By.xpath(".//*[text()='Got it!']");
	By clickPopUp2=By.xpath(".//*[text()='Got it']");
	By actionMore=By.xpath(".//*[contains(@class,'icon-action-more')]");
	By logout=By.xpath(".//*[@href='/logout']");
	
	public RoutePlannerPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getStaringPoint()
	{
		return driver.findElement(staringPoint);
	}
	
	public WebElement getEndingPoint()
	{
		return driver.findElement(endingPoint);
	}	
	
	public WebElement getSearchPlace()
	{
		return driver.findElement(searchPlace);
	}
	
	public WebElement getDestinationPointMap(String destination)
	{
		By destinationPointMap=By.xpath(".//*[text()='"+destination+"']");
		return driver.findElement(destinationPointMap);
	}
	
	public WebElement getSetDestination()
	{
		return driver.findElement(setDestination);
	}
	
	public WebElement getSetStart(String startPoint)
	{
		By setStart=By.xpath(".//*[text()='"+startPoint+"']");
		return driver.findElement(setStart);
	}
	
	public WebElement getSetStartHere()
	{
		return driver.findElement(setStartHere);
	}
	
	public WebElement getSaveTour()
	{
		return driver.findElement(saveTour);
	}
	
	public WebElement getClickPopUp()
	{
		return driver.findElement(clickPopUp);
	}
	
	public WebElement getClickAnotherPopUp()
	{
		return driver.findElement(clickPopUp2);
	}
	
	public WebElement getActionMore()
	{
		return driver.findElement(actionMore);
	}
	
	public WebElement getLogout()
	{
		return driver.findElement(logout);
	}
	
}
