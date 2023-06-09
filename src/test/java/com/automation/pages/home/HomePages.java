package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class HomePages extends BasePages {
	
	//public HomePage h;
	
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	

	public HomePages(WebDriver driver) {
		super();
		
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
