package com.test.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.base.Base;
import com.test.page.SaucedemoLoginPage;

public class SaucedemoLoginTest extends Base {
	
	public WebDriver driver;
	public SaucedemoLoginPage loginPage;
	private static final Logger log = LogManager.getLogger(SaucedemoLoginTest.class);
	
	@BeforeTest
	public void loadApplication(){
		driver = initializeDriver();
		loadBaseUrl(driver);
		loginPage = new SaucedemoLoginPage(driver);
	}
	
	@Test(priority = 1, description = "Verifying login as standard user")
	public void loginAsStandardUser() {
		
		log.info("Logging to Sauce Labs");
		loginPage.getLoginWithUsrNamePasswd("standard_user", "secret_sauce");
		log.info("Log in successful");
	}
	
	@Test(priority = 2, description = "Verifying login as standard user2")
	public void loginAsStandardUser2() {
		
		log.info("Logging to Sauce Labs");
		log.info("Log in successful");
	}

	@AfterTest
	public void suiteTearDown() {
	    driver.quit();
	    log.info("Browser closed successfully");
	}
}
