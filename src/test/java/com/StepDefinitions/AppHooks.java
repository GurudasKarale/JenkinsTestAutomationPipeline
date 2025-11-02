package com.StepDefinitions;

import com.Managers.WebdriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.Managers.ExtentManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AppHooks {
	
	//cucumber will inject this(picocontainer by default)
	//constructor 
	private final WebdriverManager webdriverManager;
	
	public AppHooks(WebdriverManager webdriverManager) {
		this.webdriverManager=webdriverManager;
	}
	
	@Before
	public void setup(io.cucumber.java.Scenario scenario){
		System.out.println("Thread " + Thread.currentThread().getId() + 
                " -> " + scenario.getName());
		webdriverManager.getDriver();
	}
	
	@After(order = 1)
	public void clearDriverContext() {
		
		webdriverManager.quitDriver();
		
	} 
	
	@AfterStep
	public void afterEachStep(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) webdriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            String stepName = scenario.getName().replaceAll(" ", "_");
            Files.createDirectories(Paths.get("target/ExtentReport/screenshots/"));
            String screenshotPath = "target/ExtentReport/screenshots/" + stepName + "_" + System.currentTimeMillis() + ".png";
            Files.write(Paths.get(screenshotPath), screenshot);

            if (scenario.isFailed()) {
                ExtentManager.getTest().fail("Step failed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                ExtentManager.getTest().info("Step passed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

	@After
    public void afterScenario() {
        ExtentManager.flush();
    }

}

