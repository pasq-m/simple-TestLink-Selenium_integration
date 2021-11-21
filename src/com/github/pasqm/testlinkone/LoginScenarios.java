package com.github.pasqm.testlinkone;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testlink.api.java.client.TestLinkAPIResults;

public class LoginScenarios {

	public static WebDriver driver;
	public static String url = "http://automationpractice.com/index.php";
	
	@Before
	public void OpenBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void validLogin() throws Exception {
		try {
			driver.get(url);
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();			//It clicks on login.
			String heading = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
			Assert.assertEquals("AUTHENTICATION", heading);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("prova.email1@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("test123");
			driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
			String title = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
			Assert.assertEquals("MY ACCOUNT", title);
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();			//Sign out.
			String logoutCheck = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
			Assert.assertEquals("AUTHENTICATION", logoutCheck);													//Logout check - check if we see the "AUTHENTICATION" title again.
			TestLinkIntegration.updateResults("20211119-18:42:59 SeleniumAutomation_Valid_Login_1", null, TestLinkAPIResults.TEST_PASSED);			
			
		} catch (Exception e) {
			TestLinkIntegration.updateResults("20211119-18:42:59 SeleniumAutomation_Valid_Login_1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
}
