package com.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLoginPage{
	
	WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	@FindBy(css=".login_logo")
	private WebElement logoInLoginPage;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement erroMsg;
	
	public SaucedemoLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void getLoginWithUsrNamePasswd(String usrname, String passwd) {
    	username.sendKeys(usrname);
    	password.sendKeys(passwd);
    	loginBtn.click();
    }

}
