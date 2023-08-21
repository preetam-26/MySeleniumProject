package com.demo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pageObjects.AddNewCustomer;
import com.demo.pageObjects.LoginPage;

import net.bytebuddy.utility.RandomString;

public class AddNewCustomerTest extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		AddNewCustomer addCust = new AddNewCustomer(driver);
		addCust.clickAddNewCustomer();
		addCust.customerName("Preetam");
		addCust.customerGender("male");
		addCust.customerDob("15", "10", "1991");
		Thread.sleep(3000);
		addCust.customerAddress("India");
		addCust.customerCity("Pune");
		addCust.customerState("MH");
		addCust.customerPin("411041");
		addCust.customerTelephone("8775464435");
		
		String email = randomeString()+"@gmail.com";
		addCust.customerEmailid(email);
		
		addCust.customerPassword("jhoih");
		addCust.customerSubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
		}else {
			captureScreenshot(driver, "AddNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomeString() {
		String generatedString = RandomString.make(8);
		return generatedString;
		
	}

}
