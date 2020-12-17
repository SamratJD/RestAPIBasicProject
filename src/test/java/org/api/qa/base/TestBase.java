package org.api.qa.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.api.qa.utilities.ExtentReporter;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase extends ExtentReporter {

	public static RequestSpecification httpRequest;
	public static Response response;

	public Logger logger;

	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("Rest API Framework");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.INFO);
	}

}
