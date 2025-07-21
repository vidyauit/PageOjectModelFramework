package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constant.ENV;
import com.utility.PropertiesUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {
      public static final int MAX_NUMBER_ATTEMPTS= Integer.parseInt(PropertiesUtility.readProperty(ENV.QA, "MAX_NUMBER_ATTEMPTS"));
      public static  int current_Attempt =1;
	@Override
	public boolean retry(ITestResult result) {
		if(current_Attempt<=MAX_NUMBER_ATTEMPTS) {
			current_Attempt++;
			return true;
		}
		return false;
	}
	
	

}
