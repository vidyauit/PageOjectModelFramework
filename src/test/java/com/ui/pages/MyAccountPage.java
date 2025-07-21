package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility{
    
	private static final By USER_NAME_LOCATOR =By.xpath("//a[contains(text(), 'Logged in as')]/b");
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    public String getUserName() {
    	return getVisibleText(USER_NAME_LOCATOR);
    }
}
