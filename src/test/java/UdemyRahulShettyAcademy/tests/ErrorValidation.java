package UdemyRahulShettyAcademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import UdemyRahulShettyAcademy.TestComponents.Retry;

import UdemyRahulShettyAcademy.TestComponents.BaseTest;
import UdemyRahulShettyAcademy.pageobjects.CartPage;
import UdemyRahulShettyAcademy.pageobjects.CheckoutPage;
import UdemyRahulShettyAcademy.pageobjects.ConformationPage;
import UdemyRahulShettyAcademy.pageobjects.LandingPage;
import UdemyRahulShettyAcademy.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {

@Test(groups= {"ErrorHandaling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException{
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		String countryName = "India";
		
		landingpage .loginapplication("Kingofthepirats@onepeice.com","Strawhat@10");
		//div[aria-label='Incorrect email or password.']
		
		//ng-tns-c4-6 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
		//div[contains(@class,'flyInOut')]
		
		System.out.println(landingpage.getErrorMessage());
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
	}
@Test(groups= {"ErrorHandaling"})
public void productErrorValidation() throws IOException{
	// TODO Auto-generated method stub
	String productName = "ZARA COAT 3";
	String countryName = "India";
	
	ProductCatalogue productCatalogue = landingpage .loginapplication("Kingofthepirates@onepeice.com","Strawhats@10");
	
	List<WebElement> products = productCatalogue.getProductList();
	productCatalogue.addProducttoCart(productName);
	CartPage cartpage = productCatalogue.goTOCart();
	
	Boolean match = cartpage.verifyProductDisplay("laptop");
	Assert.assertFalse(match);
}


}


