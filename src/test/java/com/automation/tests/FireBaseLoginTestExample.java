package com.automation.tests;

import java.util.Properties;

import com.automation.pages.base.BasePages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utility.PropertiesUtility;




public class FireBaseLoginTestExample extends BaseTest {
	public BasePages page = new BasePages();
	
	@Test
	public void login_to_firebase_testscript() throws InterruptedException {
		log.info("inside the login_to_firebase_testscript test method");		// applicationDataProperties
		//studentRegistrationProperties
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		String expectedTitle = "Selenium";

		String actualTitle = page.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	
		
		By userName = By.id("email_field");
		WebElement userNameElement = driver.findElement(userName);
		ExplicitWaitforVisibility(userNameElement, "username field");
		page.enterText(userNameElement,userId,"username");
		
		By passwrd = By.id("password_field");
		WebElement passwordElement = driver.findElement(passwrd);
		page.enterText(passwordElement,password,"password");
		
		By button = By.tagName("button");
		WebElement buttonElement = driver.findElement(button);
		page.clickElement(buttonElement,"login button");

}
	@Test
	public void error_login_firebase_testscript() throws InterruptedException {
	
		String expectedError = "Error : The password is invalid or the user does not have a password.";
		String expectedTitle = "Selenium";
		
		String actualTitle = page.getPageTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("title matched");
		} else {
			System.out.println("title is not matched");
		}
		Thread.sleep(4000);
		By userName = By.id("email_field");
		WebElement userNameElement = driver.findElement(userName);
		page.enterText(userNameElement,"admin123@gmail.com","username");
		
		By password = By.id("password_field");
		WebElement passwordElement = driver.findElement(password);
		page.enterText(passwordElement,"admin123","password");
		
		By button = By.tagName("button");
		WebElement buttonElement = driver.findElement(button);
		page.clickElement(buttonElement,"login button");
		Thread.sleep(4000);
		
		Actions action=new Actions(driver);
		//action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
		
		
		Alert alert = switchToAlert();
		String errorMsg = getAlertText(alert);
		AcceptAlert(alert);
		
		if (errorMsg.equals(expectedError)) {
			System.out.println("testcase passed");
		} else {
			System.out.println("testcae failed");
		}
		
	}
	
}
