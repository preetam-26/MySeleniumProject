package com.demo.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageObjects.LoginPage;
import com.demo.utilities.Xls_Reader;

public class LoginNumberOfData extends BaseClass {
	Xls_Reader reader;

	@Test(dataProvider="loginWithData")
	public void loginWithDatas(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		

	}

	@DataProvider(name="loginWithData")
	public String[][] getData() {
		reader = new Xls_Reader(System.getProperty("user.dir")
				+"/src/test/java/com/demo/testData/loginData.xlsx");
		int rowNum = reader.getRowCount("loginData");
		int colNum = reader.getColumnCount("loginData");
		
		String loginData[][]=new String[rowNum][colNum];
		for(int i=1; i<=rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				loginData[i-1][j]= reader.getCellData("loginData",colNum, rowNum);
			}
		}
		return loginData;
	}

}
