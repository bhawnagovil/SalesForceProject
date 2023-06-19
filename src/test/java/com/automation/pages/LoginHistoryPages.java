package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

   public class LoginHistoryPages extends BasePages {

    @FindBy(xpath= "//span[@id= 'DisplayAndLayout_font']")WebElement DisplayAndLayOutButton;
    @FindBy(xpath= "//span[@id= 'CustomizeTabs_font']")WebElement CustomizeMyTabLink ;
	
	public LoginHistoryPages(WebDriver driver) {
		super(driver);
		
	}
	

  

	
	public WebDriver clickDisplayAndLayoutLinkAnSelectCustomizeMyTab() {
		takingElementIntoViewByJavaScriptExecutor(DisplayAndLayOutButton);
		clickElementByJavaScriptExecutor(DisplayAndLayOutButton);
		clickElementByJavaScriptExecutor(CustomizeMyTabLink);
		return driver;
			
		
	}
	

}
