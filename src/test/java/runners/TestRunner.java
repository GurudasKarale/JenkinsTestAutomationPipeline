package runners;

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = {"src/test/resources/functionalTests"},
//				glue={"com.StepDefinitions"}
//		)

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("functionalTests") // folder with .feature files
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = "cucumber.glue", value = "com.StepDefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class TestRunner {
	
	
//	  static {
//	        // Enable parallel execution
//	        System.setProperty("junit.jupiter.execution.parallel.enabled", "true");
//
//	        // Run test methods (scenarios) concurrently
//	        System.setProperty("junit.jupiter.execution.parallel.mode.default", "concurrent");
//
//	        // Fixed thread pool for parallel execution
//	        System.setProperty("junit.jupiter.execution.parallel.config.strategy", "fixed");
//	        System.setProperty("junit.jupiter.execution.parallel.config.fixed.parallelism", "4");
//	    }
		

}
