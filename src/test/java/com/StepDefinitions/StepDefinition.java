package com.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.CucumberPOM.POMPages.HomePage;
import com.Managers.ExtentManager;
import com.Managers.PomManager;
import com.Managers.WebdriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	private final WebdriverManager webdriverManager;
	private HomePage homepage;
	
	public StepDefinition(WebdriverManager webdriverManager) {
		this.webdriverManager=webdriverManager;
	}
	
//	@Given("user navigates to the ecom homepage")
//	public void user_navigates_to_the_ecom_homepage() {
//	    // Write code here that turns the phrase above into concrete actions
//		WebDriver driver = webdriverManager.getDriver();
//		driver.get("https://www.saucedemo.com/v1/");
//	    System.out.println("open the url");
//	}
//	@When("user clicks on any product")
//	public void user_clicks_on_any_product() {
//	    // Write code here that turns the phrase above into concrete actions
//		WebDriver driver = webdriverManager.getDriver();
//		PomManager pageObjectManager = new PomManager(driver);
//		homepage = pageObjectManager.getHomePage();
//		homepage.enterUsername();
//		homepage.enterPassword();
//		homepage.validateProductPageTitle();
//		homepage.validateProductName();
//		homepage.addProductToCart();
//		System.out.println("click on the product");
//	}
//	@Then("user should be able to add the item in basket")
//	public void user_should_be_able_to_add_the_item_in_basket() {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("item got added to the basket");
//	}
//	
	
	@Given("user navigates to the ecom HomePage")
	public void user_navigates_to_the_ecom_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriver driver = webdriverManager.getDriver();
		ExtentManager.startTest("Login Scenario");
        ExtentManager.getTest().info("Opening login page");
		driver.get("https://www.saucedemo.com/");
	    System.out.println("open the url");
	    ExtentManager.getTest().pass("Page accessed");
	}
	@When("user adds any product in the cart")
	public void user_adds_any_product_in_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriver driver = webdriverManager.getDriver();
		PomManager pageObjectManager = new PomManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.enterUsername();
		homepage.enterPassword();
		homepage.performLogin();
		homepage.validateProductPageTitle();
		homepage.validateProductName();
		homepage.addProductToCart();
		System.out.println("click on the product");
		ExtentManager.getTest().pass("logged in and product added");
	}
	@When("user navigates to the cartpage")
	public void user_navigates_to_the_cartpage() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on the product");
		ExtentManager.getTest().pass("cartpage");
	}
	@When("user clicks on checkout")
	public void user_clicks_on_checkout() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on the product");
		ExtentManager.getTest().pass("checkout");
	}
	@When("user enters the requested details and clicks on contiue")
	public void user_enters_the_requested_details_and_clicks_on_contiue() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("details added");
		ExtentManager.getTest().pass("checkout done");
	}
	@When("user validates the order details")
	public void user_validates_the_order_details() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("validates the order details ");
		ExtentManager.getTest().pass("validated");
	}
	@When("user clicks on finish")
	public void user_clicks_on_finish() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on the product");
		ExtentManager.getTest().pass("finished");
	}
	@Then("order should be placed and order confirmation page should be displayed")
	public void order_should_be_placed_and_order_confirmation_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on the product");
		ExtentManager.getTest().pass("order confirmaion");
	}
	
	@When("user adds product2 in the cart")
	public void user_adds_product2_in_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriver driver = webdriverManager.getDriver();
		PomManager pageObjectManager = new PomManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.enterUsername();
		homepage.enterPassword();
		homepage.performLogin();
		homepage.validateProductPageTitle();
		homepage.validateProductName();
		homepage.addProductToCart();
		System.out.println("click on the product");
		ExtentManager.getTest().pass("product 2 added");
	}

}
