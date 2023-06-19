package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class EmailSettingPages extends BasePages{
	
	 @FindBy(id="sender_name")WebElement EmailTextBox;
     @FindBy(id="sender_email")WebElement EmailAddress;
     @FindBy(id="auto_bcc1")WebElement RadioAutomaticBcc;
     @FindBy(xpath="//input[@name='save']")WebElement SaveButton;

	public EmailSettingPages(WebDriver driver) {
		super(driver);
		
	}
	
	public WebDriver sendEmailAndEmailAddressAddselectRadioBCCAndSelectSave(String emaildata, String emailaddressData) {
		cleartext(EmailTextBox);
		enterText(EmailTextBox, emaildata, "Email Name");
		cleartext(EmailAddress);
		enterText(EmailAddress, emailaddressData , "Email Address");
		clickElement(RadioAutomaticBcc, " Automatic BCC Radio Button");
		clickElement(SaveButton, "Save Button");
		return driver;
	}
	
	
	

}
