package com.demo.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demo.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();	
	public String baseUrl = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
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
		driver.get(baseUrl);

		logger= Logger.getLogger("demo");
		PropertyConfigurator.configure("Log4j.properties");
//		driver.get("http://www.google.com");
//		driver.manage().window().maximize();
//		System.out.println(driver.getTitle());
//		driver.close();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
	}
	

}
