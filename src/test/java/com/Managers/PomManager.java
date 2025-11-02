package com.Managers;

import org.openqa.selenium.WebDriver;

import com.CucumberPOM.POMPages.HomePage;

public class PomManager {
	
	private HomePage homePage;
	private WebDriver driver;

	public PomManager(WebDriver driver) {
		this.driver=driver;
	}

	public HomePage getHomePage() {
		return homePage=new HomePage(driver);
	}

}
