package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constant.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class LoginTest extends BaseTest{
	
	Logger logger = LoggerUtility.getLogger(getClass());
	
	@BeforeMethod(description = "Login to Home Page of the website")
	public void setUp() {
		homepage = new HomePage(EDGE);
		homepage.maximizeWindow();
	}
//	
//	@Test(description = "Verify with the valid user is login the application " , groups={"e2e","sanity"},dataProviderClass = com.ui.dataprovider.LoginDataProvider.class ,dataProvider = "loginTestDataProvider")
//	public void loginTest(User user) {	
//		
//		String username = homepage.goTOLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
//		System.out.println(username);
//		
//
//	}
//
//	@Test(description = "Verify with the valid user is login the application " , groups={"e2e","sanity"},dataProviderClass = com.ui.dataprovider.LoginDataProvider.class ,dataProvider = "loginTestDataProvider")
//	public void loginCSVTest(User user) {
//		assertEquals(homepage.goTOLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"vidya");
//	}

	
	@Test(description = "Verify with the valid user is login the application " , groups={"e2e","sanity"},dataProviderClass = com.ui.dataprovider.LoginDataProvider.class ,dataProvider = "loginSSFXDataprovider",
			      retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class )
	public void loginXSSFExcelTest(User user) {
		
		logger.info("Started my login test");
		assertEquals(homepage.goTOLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"vidya");
	    logger.info("Login Excel Test Completed!!!");
	}

	}


