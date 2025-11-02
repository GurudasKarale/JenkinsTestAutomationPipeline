package com.CucumberPOM.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//WebDriver driver;
	
	public HomePage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH , using ="//input[@id=\"user-name\"]")
	private WebElement Username;
	
	@FindBy(how=How.XPATH , using ="//input[@id=\"password\"]")
	private WebElement Pwd;
	
	@FindBy(how=How.XPATH , using ="//input[@id=\"login-button\"]")
	private WebElement LoginButton;
	
	@FindBy(how=How.XPATH , using ="//div[@class=\"product_label\"]")
	private WebElement ProductsPage;
	
	@FindBy(how=How.XPATH , using ="//div[@class=\"inventory_item_name\"]")
	private WebElement ProductName;
	
	@FindBy(how=How.XPATH,using="//button[@class=\"btn_primary btn_inventory\"]")
	private WebElement AddToCartButton;
	
	public void enterUsername() {
		Username.sendKeys("standard_user");
	}
	
	public void enterPassword() {
		Pwd.sendKeys("secret_sauce");
	}
	
	public void performLogin() {
		LoginButton.click();
	}

	public void validateProductPageTitle() {
		ProductsPage.getText();
	}
	
	public void validateProductName() {
		ProductName.getText();
	}
	
	public void addProductToCart() {
		AddToCartButton.click();
	}
}
