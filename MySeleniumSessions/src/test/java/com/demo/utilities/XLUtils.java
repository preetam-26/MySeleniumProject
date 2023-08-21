package com.demo.utilities;

import java.util.ArrayList;

public class XLUtils {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromXcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(System.getProperty("user.dir")
					+"/src/test/java/com/demo/testData/loginData.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("loginData");
		System.out.println(rowCount);
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			
			String username = reader.getCellData("loginData", "username", rowNum);
			String password = reader.getCellData("loginData", "password", rowNum);
				
			Object[] obj = {username, password};
			myData.add(obj);
		}
		return myData;	
	}

}
