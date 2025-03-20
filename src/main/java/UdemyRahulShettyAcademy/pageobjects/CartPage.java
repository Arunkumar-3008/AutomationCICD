package UdemyRahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UdemyRahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
		
		WebDriver driver;
		
		public  CartPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements( driver,this);
		}
		
		
		
		@FindBy(xpath="//div[@class='cartSection']/h3")
		List<WebElement> cartProducts;
		
		@FindBy(css = ".totalRow button")
		WebElement Checkoutbtn;
		
		
		public Boolean verifyProductDisplay(String productName)
		{
			Boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
			return match;
			
		}
		
		public CheckoutPage goToCheckout() {
			Actions a = new Actions(driver);
			a.moveToElement(Checkoutbtn).doubleClick().build().perform();
			//Checkoutbtn.click();
			CheckoutPage checkoutpage = new CheckoutPage(driver);
			return checkoutpage;
			
			
		}

}
