package com.test.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.test.base.Base;
import com.test.page.SaucedemoHomePage;

public class SaucedemoHomeTest extends Base{
	
	SaucedemoHomePage sd = new SaucedemoHomePage();
	private static final Logger log = LogManager.getLogger(SaucedemoHomeTest.class.getName());
	
	@BeforeTest
	public void loadApplication(){
		driver = initializeDriver();
		loadBaseUrl(driver);
	}
	
	@Test
	public void testHomePageLoad(){
		
		log.info("Verifying home page");
		Assert.assertEquals(sd.getHomegPageLogo().isDisplayed(), true);
		
		log.info("Expected Title - Swag Labs, Actual title - "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
			
	}
	
	@AfterTest
	public void suiteTearDown() {
	    driver.quit();
	    log.info("Browser closed successfully");
	}

}
