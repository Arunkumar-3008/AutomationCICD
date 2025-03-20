package UdemyRahulShettyAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UdemyRahulShettyAcademy.TestComponents.BaseTest;
import UdemyRahulShettyAcademy.pageobjects.CartPage;
import UdemyRahulShettyAcademy.pageobjects.CheckoutPage;
import UdemyRahulShettyAcademy.pageobjects.ConformationPage;
import UdemyRahulShettyAcademy.pageobjects.LandingPage;
import UdemyRahulShettyAcademy.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionsImplementation extends BaseTest {
	
	public LandingPage landingpage ;
	public ProductCatalogue productCatalogue ;
	public ConformationPage conformationpage;

	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		landingpage=launchApplication();
	    //throw new io.cucumber.java.PendingException();
	}
	@Given("^Logged in  with username(.+) and Password (.+)$")
	public void logged_in_username_and_password(String username, String Password)
	{
		productCatalogue = landingpage .loginapplication(username,Password);
	}
	@When("^I add  the product (.+) to cart$") 
	public void I_add_the_product_to_cart(String productname)
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProducttoCart(productname);
	}
	@When("^Checkout(.+) and submit order$")
	public void Checkout_productname_and_submit_order(String productname)
	{
		CartPage cartpage = productCatalogue.goTOCart();
		
		Boolean match = cartpage.verifyProductDisplay(productname);
		//Assert.assertTrue(match);
		
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		
		checkoutpage.selectCountry("India" );
		
		conformationpage =checkoutpage.submitbtn();
	}
	//@Then ("^(.+)message is displayed on Confirmation Page.$")
	@Then("{String} message is displayed on Confirmation Page")
	public void message_is_displayed_on_Confirmation_Page(String Message)
	{
		String ConfirmMessage = conformationpage.getConformationMessage();
		System.out.println(ConfirmMessage);
		//Assert.assertTrue(Message.equalsIgnoreCase(ConfirmMessage));
		//Assert.assertEquals(ConfirmMessage, Message);
		driver.close();
	}
	@Then("{String} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string,landingpage.getErrorMessage());
		driver.close();
		
	}

}
