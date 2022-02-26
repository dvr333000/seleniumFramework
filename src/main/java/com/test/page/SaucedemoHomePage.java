package com.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.test.base.Base;

public class SaucedemoHomePage extends Base{
	
	private By homePageLogo = By.cssSelector(".login_logo");
	
	public WebElement getHomegPageLogo(){
		return driver.findElement(homePageLogo);
	}

	public void testHomePageLoad(){
		
		System.out.println(driver.findElement(homePageLogo).isDisplayed());
	}

}
