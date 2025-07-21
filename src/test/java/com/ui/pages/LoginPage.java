package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By emailTextBoxLocator =  By.xpath("(//input[@name='email'])[1]");
	private static final By passwordTextBoxLocator = By.xpath("(//input[@name='password'])[1]");
	private static final By submitButtonLocator = By.xpath("(//button[text()='Login'])[1]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    public MyAccountPage doLoginWith(String email,String password) {
    	 enterText(emailTextBoxLocator, email);
    	 enterText(passwordTextBoxLocator, password);
    	 clickOn(submitButtonLocator);
    	 MyAccountPage myacountpage = new MyAccountPage(getDriver());
    	 return myacountpage;
    }
}
