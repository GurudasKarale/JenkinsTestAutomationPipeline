package com.Managers;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManager {
	
	//private WebDriver driver;
	
	private ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(()->{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mohit K\\Desktop\\java\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
//		 ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless"); // Run Chrome in headless mode
//	        options.addArguments("--disable-gpu");
//	        options.addArguments("--window-size=1920,1080");
		
		return new ChromeDriver();
		
	});
	
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void quitDriver() {
		driver.get().quit();
		driver.remove();
	}

}
