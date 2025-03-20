package UdemyRahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UdemyRahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	
	public  CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//section/button[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitbtn;
	
	By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	public void selectCountry(String countryName)
	{
		Actions b = new Actions(driver);
		b.sendKeys(country,countryName).build().perform();
		waitForElementtoAppear(results);
		selectCountry.click();
	}
	public ConformationPage submitbtn()
	{
		Actions c = new Actions(driver);
		c.moveToElement(submitbtn).click().build().perform();
		ConformationPage conformationpage = new ConformationPage(driver);
		return conformationpage;
	}

}
