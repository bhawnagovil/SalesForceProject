package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{
	
	//public HomePage h;
	
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	

	public WebDriver selectElementfromDropDown(String text) {
		selectOptionFromDropDownByVisibleText(UserMenuDropDown, text, "logout Option");
		//selectOptionFromDropDownByVisibleText(UserMenuDropDown,text,"logout Option");
		return driver;
	}
	
	public WebDriver selectMYProfileElementfromDropDown(String text) {
		selectOptionFromDropDownByVisibleText(UserMenuDropDown, text, "My Profile");
		
		return driver;
	}
	
	
	
	
	
	
	

	
	
}
