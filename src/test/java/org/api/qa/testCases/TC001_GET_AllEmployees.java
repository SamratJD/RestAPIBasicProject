package org.api.qa.testCases;

import org.api.qa.base.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_AllEmployees extends TestBase {
	public String authorName = "Author: Samrat Nag";
	public String deviceName = "Device: Offshore Desktop";
	public String tagName = "Endpoint: GET_AllEmployees";
	public String testCase = "GET All Employees";

	@BeforeClass
	void getAllEmployees() {
		logger.info(
				"==============================================================Started TC001=======================================================================");
		RestAssured.baseURI = "http://dummy.restapiexample.com/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/api/v1/employees");
	}

	@Test
	void verifyStatusCode() {
		String testCase1 = testCase + ": Status code validation";
		logger.info(
				"==============================================================Status code validation=======================================================================");
		int statusCode = response.getStatusCode();
		logger.info("Status code is: " + statusCode);
		if (statusCode == 200)
			extent.createTest(testCase1).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Status code validation passed");
		else
			extent.createTest(testCase1).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName).fail(
					"Status code validation failed" + "\n Actual value: " + statusCode + "\n Expected value: " + 200);
	}

	@Test
	void verifyResponseBody() {
		String testCase2 = testCase + ": Response body validation";
		logger.info(
				"==============================================================Response body validation=======================================================================");
		String responseBody = response.getBody().toString();
		logger.info("Response body is: " + responseBody);
		if (responseBody != null)
			extent.createTest(testCase2).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Response body validation passed");
		else
			extent.createTest(testCase2).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.fail("Response body validation failed, response body is null");
	}

	@Test
	void verifyResponseTime() {
		String testCase3 = testCase + ": Response time validation";
		logger.info(
				"==============================================================Response time validation=======================================================================");
		long responseTime = response.getTime();
		logger.info("Response time is: " + responseTime);
		if (responseTime <= 1000)
			extent.createTest(testCase3).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Response time validation passed");
		else
			extent.createTest(testCase3).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.fail("Response time validation failed, response time taken is > 1s");
	}

	@Test
	void verifyStatusLine() {
		String testCase4 = testCase + ": Status line validation";
		logger.info(
				"==============================================================Status line validation=======================================================================");
		String statusLine = response.getStatusLine();
		logger.info("Status line is: " + statusLine);
		if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
			extent.createTest(testCase4).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Status line validation passed");
		else
			extent.createTest(testCase4).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.fail("Status line validation failed" + "\n Actual value: " + statusLine
							+ "\n Expected value: HTTP/1.1 200 OK");
	}

	@Test
	void verifyContentType() {
		String testCase5 = testCase + ": Content type validation";
		logger.info(
				"==============================================================Content type validation=======================================================================");
		String contentType = response.header("Content-Type");
		logger.info("Content type is: " + contentType);
		if (contentType.equalsIgnoreCase("application/json;charset=utf-8"))
			extent.createTest(testCase5).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Content type validation passed");
		else
			extent.createTest(testCase5).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.fail("Content type validation failed" + "\n Actual value: " + contentType
							+ "\n Expected value: application/json;charset=utf-8");
	}

	@Test
	void verifyServer() {
		String testCase6 = testCase + ": Server validation";
		logger.info(
				"==============================================================Server validation=======================================================================");
		String server = response.header("Server");
		logger.info("Server is: " + server);
		if (server.equalsIgnoreCase("nginx/1.16.0"))
			extent.createTest(testCase6).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Server validation passed");
		else
			extent.createTest(testCase6).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName).fail(
					"Server validation failed" + "\n Actual value: " + server + "\n Expected value: nginx/1.16.0");
	}

	@Test
	void verifycontentLength() {
		String testCase7 = testCase + ": Content Length validation";
		logger.info(
				"==============================================================Content Length validation=======================================================================");
		String contentLength = response.header("Content-Length");
		logger.info("Content Length is: " + contentLength);
		if (Integer.parseInt(contentLength) > 10)
			extent.createTest(testCase7).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.pass("Content Length validation passed");
		else
			extent.createTest(testCase7).assignAuthor(authorName).assignDevice(deviceName).assignCategory(tagName)
					.fail("Content Length validation failed, content length is > 10");
	}

	@AfterTest
	void tearDown() {
		logger.info(
				"==============================================================Ended TC001=======================================================================");
		extent.flush();
	}

}
