package com.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class DeveloperConsolePage extends BasePages{
	


	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	@FindBy(xpath="//a[text()='Developer Console']")WebElement DeveloperConsole;
	
	public DeveloperConsolePage(WebDriver driver){
		super(driver);
	}
	
	public void selectinguserMenuDropDown() {
		applyImplicitWait();
		waitUntilElementIsClickable(UserMenuDropDown);
		clickElement(UserMenuDropDown, "UserMenuDropDown");
	}
	
	public WebDriver selectingDeveloperConsoleFromHomePageDropDown() {
		waitUntilElementIsClickable(UserMenuDropDown);
		selectinguserMenuDropDown();
		clickElement(DeveloperConsole, "DeveloperConsole");
		return driver;
			
	}
	
	public void ClosingDeveloperConsoleWindow() {
		switchingFromHomeToDeveloperConsoleHandleWindows();
	
			
	}
	
	public void clickSaveButton() {
		clickElement(DeveloperConsole, getPageTitle());
	}
	
	

	
	
	
	
}
