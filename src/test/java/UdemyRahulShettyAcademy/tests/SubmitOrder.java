package UdemyRahulShettyAcademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UdemyRahulShettyAcademy.TestComponents.BaseTest;
import UdemyRahulShettyAcademy.pageobjects.CartPage;
import UdemyRahulShettyAcademy.pageobjects.CheckoutPage;
import UdemyRahulShettyAcademy.pageobjects.ConformationPage;
import UdemyRahulShettyAcademy.pageobjects.LandingPage;
import UdemyRahulShettyAcademy.pageobjects.OderPage;
import UdemyRahulShettyAcademy.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {

	String productName = "ZARA COAT 3";
	String countryName = "India";
@Test(dataProvider="getData",groups= {"Purchase order"})
	public void submitOrder(HashMap<String,String> input) throws IOException{
		// TODO Auto-generated method stub
		//check this -20/03/2025
		
		ProductCatalogue productCatalogue = landingpage .loginapplication(input.get("email"),input.get("password"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProducttoCart(input.get("productName"));
		CartPage cartpage = productCatalogue.goTOCart();
		
		Boolean match = cartpage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		
		checkoutpage.selectCountry(input.get("countryName") );
		
		ConformationPage conformationpage =checkoutpage.submitbtn();
		
		
		
		
		String ConfirmMessage = conformationpage.getConformationMessage();
		System.out.println(ConfirmMessage);
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	}

	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData",groups= {"Purchase order"})
	public void oderHistoryTest(HashMap<String,String> input)throws IOException
	{
		ProductCatalogue productCatalogue = landingpage .loginapplication(input.get("email"),input.get("password"));
		OderPage oderpage = productCatalogue.goToOderPage();
		
		Assert.assertTrue(oderpage.verifyOderDisplay(input.get("productName")));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//HashMap<String,String> map = new HashMap<String,String>();
		//map.put("email","Kingofthepirates@onepeice.com" );
		//map.put("password","Strawhats@10");
		//map.put("productName", "ZARA COAT 3");
		//map.put("countryName", "India");
		
		//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email","Firstcommander@strawhats.com" );
		//map1.put("password","Strawhats@10");
		//map1.put("productName", "IPHONE 13 PRO");
		//map1.put("countryName", "India");
		
		List<HashMap<String,String>> data = getJSONDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\UdemyRahulShettyAcademy\\data\\PurchaseOrder.json");
		 return new Object[][]  { {data.get(0)} , {data.get(1)} };
	}
	
	

}
