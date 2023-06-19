package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class MySettingpage extends BasePages {

	MySettingpage s;
	
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	@FindBy(xpath="//a[text()='My Settings']")WebElement MySettingOption;
	@FindBy(id="PersonalInfo_font")WebElement PersonalButtonElement;
	@FindBy(xpath="//span[@id='LoginHistory_font']")WebElement LoginHistoryLink;
	@FindBy(xpath="//span[@id='CustomizeTabs_font']")WebElement customizeMyTabEle;
	@FindBy(xpath="//a[@id='PersonalInformation_font']")WebElement PersonalInformationLink;
     @FindBy(id="EmailSetup_font")WebElement EmailButton;
     @FindBy(id="EmailSettings_font")WebElement MyEmailsettingButton;   
     @FindBy(id="CalendarAndReminders_font")WebElement CalendarAndReminder;
     @FindBy(id="Reminders_font")WebElement ActivityReminder;
    
     
	
	public MySettingpage(WebDriver driver) {
		super(driver);
		
	}
	

	public WebDriver selectingMySettingFromHomePageDropDown() {
		waitUntilElementIsClickable(UserMenuDropDown);
		selectinguserMenuDropDown();
	    clickElement(MySettingOption, "MySettingOption");	
		return driver;
	}
	
	public WebDriver clickingPersonalInformationAndPersonalLink() {
		clickElementByJavaScriptExecutor(PersonalButtonElement);
		ExplicitWaitforVisibility(PersonalInformationLink, "PersonalInformationLink");
		clickElementByJavaScriptExecutor(PersonalInformationLink);
		return driver;
	}
	
	public WebDriver clickPersonalLinkAndSelectDownLoadLoginHistory() {
		clickElementByJavaScriptExecutor(PersonalButtonElement);
		ExplicitWaitforVisibility(PersonalInformationLink, "PersonalInformationLink");
		clickElementByJavaScriptExecutor(LoginHistoryLink);
		return driver;
	}
	
	public WebDriver clickEmailAndMyEmailSettingLink() {
		applyImplicitWait();
		clickElementByJavaScriptExecutor(EmailButton);
		ExplicitWaitforVisibility(MyEmailsettingButton, "MyEmailsettingButton");
		s.clickElementByJavaScriptExecutor(MyEmailsettingButton);
		return driver;
	}
	

	
	public WebDriver clickCalendarAndRemindersLinkAndSelectActivityReminders(){
		applyImplicitWait();
		clickElement(CalendarAndReminder,"CalendarAndReminder");
		ExplicitWaitforVisibility(ActivityReminder, "Activity Reminder");
		clickElement(ActivityReminder,"Activity Reminder Link");
		return driver;
	}
	
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
