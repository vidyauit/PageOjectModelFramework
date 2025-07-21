package com.ui.test;
import org.testng.annotations.Test;

import com.utility.readingData;

public class getDataTest extends GetDataValues{

	
	@Test(dataProviderClass = GetDataValues.class ,dataProvider = "getData")
	public void getdatvalue(String username,String pwd) {
		
		System.out.println(username);
		System.out.println(pwd);
		
		
	}
}
