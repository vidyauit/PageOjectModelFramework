package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.Browser;
import com.constant.ENV;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(getClass());
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
    
	public BrowserUtility(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			 driver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("Edge")){
			driver.set(new EdgeDriver());
		}
		else {
			System.out.println("enter the wrong browser");
		}
	}
	
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE){
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX){
			driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("enter the wrong browser");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless"); // headless
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

			else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		}
	
	public void goToWebSite(String url) {
		System.out.println(url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element =driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator,String text) {
		WebElement element  = driver.get().findElement(locator);
		element.sendKeys(text);
	}

    public String getVisibleText(By locator){
    	WebElement element  = driver.get().findElement(locator);
    	return element.getText();
    }
    
    public void clickOnCheckBox(By locator) {
		logger.info("Finding Element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);// Find the element!!!
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now performing Click");

		element.click();
	}


	public void clearText(By textBoxLocator) {
		logger.info("Finding Element with the locator" + textBoxLocator);

		// WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

		logger.info("Element Found and clearing the text box field");

		element.clear();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the Option " + optionToSelect);

		select.selectByVisibleText(optionToSelect);
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now enter special Key " + keyToEnter);

		element.sendKeys(keyToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All Elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the List of Elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}

		return visibleTextList;

	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding All Elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the List of Elements");

		return elementList;

	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visibile Text" + element.getText());

		return element.getText();
	}

    
    public String takeScreenShot(String name) {
    	
    	TakesScreenshot screenshot = (TakesScreenshot)driver.get(); 	
    	File source = screenshot.getScreenshotAs(OutputType.FILE);
    	Date date = new Date();
    	SimpleDateFormat formate = new SimpleDateFormat("HH-mm-ss");
    	String timestamp = formate.format(date);
    	String path =System.getProperty("user.dir")+"\\screenshots"+name +"-"+timestamp+" .png";
    	File file = new File(path);
    	
    	try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return path;
    	
    }
}
