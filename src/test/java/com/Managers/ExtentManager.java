package com.Managers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/Spark.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest extentTest = getExtent().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void flush() {
        if (extent != null)
            extent.flush();
    }


}
