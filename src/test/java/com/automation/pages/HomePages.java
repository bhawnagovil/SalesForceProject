package com.automation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class HomePages extends BasePages {
	
	
	
	public @FindBy(xpath= "//span[@id='userNavLabel']") WebElement UserMenuDropDown;
	public @FindBy(xpath= "//a[text()= 'Logout']")WebElement Logout;
	@FindBy(xpath="//a[text()='My Settings']")WebElement MySettingOption;
	@FindBy(xpath="//li[@id='Account_Tab']")WebElement AccountlinkTab;
	@FindBy(xpath="//li/a[text()='Opportunities']")WebElement OpportynityLink;
	@FindBy(xpath="//a[text()= 'Leads']")WebElement LeadsLink;

	public HomePages(WebDriver driver) {
		super(driver);
		
	}
	public void switchingFromParentToChildHandleLighningPOPUP() {
	   	 Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
	         Iterator<String> it = windows.iterator();
	         String parentId = it.next();
	         String childId = it.next();
	         driver.switchTo().window(childId);
	         	
	   }
	public WebDriver clickLeadsLink() {
		clickElementByJavaScriptExecutor(LeadsLink);
		return driver;	
	}
	
	public WebDriver clickOpportunityLink() {
		clickElementByJavaScriptExecutor(OpportynityLink);
		return driver;	
	}
	
	public WebDriver clickAccountTab() {
		clickElement(AccountlinkTab, "Account link tab on the home page");
		return driver;
		
	}
	

	public WebDriver selectLogoutElementfromDropDown() {
		waitUntilElementIsClickable(UserMenuDropDown);
		selectinguserMenuDropDown();
		clickElement(Logout, getPageTitle());
		return driver;
	}
	
	public WebDriver selectMYProfileElementfromDropDown(String text) {
		selectOptionFromDropDownByVisibleText(UserMenuDropDown, text, "My Profile");
		
		return driver;
	}
	public WebDriver selectingLogoutFromHome() {
		selectinguserMenuDropDown();
		clickElement(Logout, "logout");
		return driver;
		
	}
	public WebDriver selectingMySettingFromHomePageDropDown() {
		waitUntilElementIsClickable(UserMenuDropDown);
		selectinguserMenuDropDown();
	    clickElement(MySettingOption, "MySettingOption");	
		return driver;
	}
	
	
	
	
	
	
	
	

	
	
}
