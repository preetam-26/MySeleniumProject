package com.demo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		logger.info("Url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}

}
