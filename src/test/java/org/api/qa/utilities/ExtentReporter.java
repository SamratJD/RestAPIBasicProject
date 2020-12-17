package org.api.qa.utilities;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;

	@BeforeTest
	public void extentSetup() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//target//Test Results.html");
		extent.attachReporter(spark);
	}
}
