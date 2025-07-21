package com.ui.test;

import static com.constant.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class BaseTest {

	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(getClass());
	
	@BeforeMethod(description = "Login to Home Page of the website")
	public void setUp() {
		homepage = new HomePage(EDGE);
		homepage.maximizeWindow();
	}
	
	public BrowserUtility getInstence() {
		
		return homepage;
	}
}
