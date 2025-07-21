package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.constant.ENV;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtility;
import com.constant.ENV;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATER = By.xpath("//a[contains(text(),' Signup / Login')]");
	public HomePage(Browser broswerName) {
		super(broswerName);
		String URL = PropertiesUtility.readProperty(ENV.QA, "URL");
		System.out.println("URL of the application"+URL);
		 goToWebSite(PropertiesUtility.readProperty(ENV.QA, "URL"));
		// TODO Auto-generated constructor stub
	}

	public LoginPage goTOLoginPage() {// in design pattern void return type can't use
		clickOn(SIGN_IN_LINK_LOCATER);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}
}
