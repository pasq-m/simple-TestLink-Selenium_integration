package com.github.pasqm.testlinkone;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	
	public static final String TESTLINK_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "SeleniumAutomation";
	public static final String TEST_PLAN_NAME = "SeleniumAutomation Test Plan 1";
	//public static final String TEST_CASE_NAME = "SeleniumAutomation_Valid_Login_1";
	public static final String TEST_CASE_NAME = "20211119-18:42:59 SeleniumAutomation_Valid_Login_1";	
	public static final String BUILD_NAME = "SeleniumAutomation first test build 0.1";
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException {
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
	}

}
