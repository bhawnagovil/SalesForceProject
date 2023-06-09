package com.automation.pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ForgetPasswordPOM extends BasePage
{
	@FindBy(id="un")WebElement forgetPassUserNameEle;
	@FindBy(id="continue")WebElement continueButtonEle;

	public ForgetPasswordPOM(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterUsername(String usernamedata) {
		enterText(forgetPassUserNameEle, usernamedata, "username field");
	}
	
	public WebDriver clickContinueButton(){
		clickElement(continueButtonEle, "ContinueButton");
		return driver;
	}
	
	
	
	

}
