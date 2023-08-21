package com.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
