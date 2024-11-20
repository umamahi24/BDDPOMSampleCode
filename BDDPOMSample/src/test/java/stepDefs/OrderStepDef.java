package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	
	WebDriver driver=TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	public OrderStepDef() {
		
		loginPage=new LoginPage(driver);// passing driver to each page object
		listPage=new ProductListPage(driver);
		cartPage=new CartPage(driver);
		checkOutPage=new CheckOutPage(driver);
		
		
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		

	    TestBase.openUrl("https://sauceDemo.com");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String user, String pswd) {
	    loginPage.validLogin(user, pswd);
	}
	
	
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(listPage.isOnproducts());
	    
	}
	@Given("User is on cart page")
	public void user_is_on_cart_page() {
		cartPage.isItemAdded();
	  
	}
	@When("User do checkout")
	public void user_do_checkout() {
		listPage.viewCart();
		cartPage.proceedCheckout();
		checkOutPage.enterCheckOutDetails("ee", "wefe", "35");
	  
	}
	@Then("Should navigate to Checkout page")
	public void should_navigate_to_checkout_page() {
	   
	}

	
	@When("User add Item to cart")
	public void user_add_item_to_cart() {
		listPage.addTocart();
	   
	}
	@Then("Item must be added")
	public void item_must_be_added() {
		listPage.viewCart();
		
	   
	}

}
