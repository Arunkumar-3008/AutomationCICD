package UdemyRahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UdemyRahulShettyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements( driver,this);
	}

	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[contains(@class,'flyInOut')]")
	WebElement errorMessage;
	
	public ProductCatalogue loginapplication(String email, String passwords)
	{
		userEmail.sendKeys(email);
		password.sendKeys(passwords);
		loginbtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementtoAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}