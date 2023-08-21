package com.demo.testCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demo.pageObjects.LoginPage;
import com.demo.utilities.ReadConfig;
import com.demo.utilities.XLUtils;

public class LoginDDT{
	public WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	
	@Parameters(value="browser")
	@BeforeMethod
	public void setup(String br) {
		if(br.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(readConfig.getApplicationUrl());
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testData = XLUtils.getDataFromXcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getData")
	public void loginTest(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
