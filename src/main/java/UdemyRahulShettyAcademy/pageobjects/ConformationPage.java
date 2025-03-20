package UdemyRahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UdemyRahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ConformationPage extends AbstractComponent {
	WebDriver driver;
	
	public  ConformationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConformationMessage()
	{
		return confirmationMessage.getText();
	}

}
