package UdemyRahulShettyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UdemyRahulShettyAcademy.pageobjects.CartPage;
import UdemyRahulShettyAcademy.pageobjects.OderPage;

public class AbstractComponent {
	
	WebDriver  driver;
	

public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		
	}
@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
WebElement cartHeader;

@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
WebElement myOders;


public void waitForElementtoAppear(By findBY) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBY));
	
}
public void waitForWebElementtoAppear(WebElement findBY) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBY));

}
public CartPage  goTOCart()
{
	cartHeader.click();
	CartPage cartpage = new CartPage(driver);
	return cartpage;
	
	
}

public OderPage  goToOderPage()
{
	myOders.click();
	OderPage oderpage = new OderPage(driver);
	return oderpage;
	
	
}
public void waitForElementToDisappear(WebElement ele) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	
	
}
	
	
}
