package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class MySettingpage extends BasePages {

	MySettingpage s;
	
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	@FindBy(id="PersonalInfo_font")WebElement PersonalButtonElement;
	@FindBy(xpath="//span[@id='LoginHistory_font']")WebElement LoginHistoryLink;
	@FindBy(id="DisplayAndLayout_font")WebElement DispayAndLayoutButton;
	@FindBy(xpath="//span[@id='CustomizeTabs_font']")WebElement customizeMyTabEle;
	@FindBy(xpath="//select[@id='p4']")WebElement customAppdropdownEle;
	@FindBy(xpath="//a[@id='PersonalInformation_font']")WebElement PersonalInformationLink;
     @FindBy(xpath= "CustomizeTabs_font")WebElement CustomizeMyTabLink;
     @FindBy(id="p4")WebElement CustomAppDropDown;
     @FindBy(id= "duel_select_0")WebElement AvailableTabsDropDown;
     @FindBy(xpath="//img[@title='Add']")WebElement AddButton;
     @FindBy(id="EmailSetup_font")WebElement EmailButton;
     @FindBy(id="EmailSettings_font")WebElement MyEmailsettingButton;
     @FindBy(id="sender_name")WebElement EmailTextBox;
     @FindBy(id="sender_email")WebElement EmailAddress;
     @FindBy(id="auto_bcc1")WebElement RadioAutomaticBcc;
     @FindBy(xpath="//input[@name='save']")WebElement SaveButton;
     @FindBy(id="CalendarAndReminders_font")WebElement CalendarAndReminder;
     @FindBy(id="Reminders_font")WebElement ActivityReminder;
     @FindBy(id= "testbtn")WebElement OpenTestReminderButton;
     
	
	public MySettingpage(WebDriver driver) {
		super();
		
	}

	public WebDriver selectingMySettingFromHomePageDropDown() {
		navigatingfromLoginToHome("usertext","passwordtext");
		selectOptionFromDropDownByVisibleText(UserMenuDropDown,"My Setting", "My Profile Option");	
		return driver;
	}
	
	public WebDriver clickingPersonalInformationAndPersonalLink() {
		
		clickElement(PersonalButtonElement,"Personal Information");
		ExplicitWaitforVisibility(PersonalInformationLink, "PersonalInformationLink");
		clickElement(PersonalButtonElement, "PersonalInformationLink");
		return driver;
	}
	
	public WebDriver clickPersonalLinkAndSelectDownLoadLoginHistory() {
		clickElement(PersonalButtonElement,"Personal Information");
		ExplicitWaitforVisibility(PersonalInformationLink, "PersonalInformationLink");
		clickElement(LoginHistoryLink, "LoginHistoryLink");
		return driver;
	}
	
	public WebDriver clickDisplayAndLayoutLinkAnSelectCustomizeMyTab() {
		clickElement(DispayAndLayoutButton,"DispayAndLayout Button");
		ExplicitWaitforVisibility(DispayAndLayoutButton, "DispayAndLayoutButton");
		clickElement(CustomizeMyTabLink,"CustomizeMyTabLink");
		return driver;
			
		
	}
	
	public void selectSalesforceChatterFromDropDown() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(CustomAppDropDown, "Salesforce Chatter","Salesforce Chatter" );
		
	}
	public void selectReportsTabFromDropDown() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(AvailableTabsDropDown, "Reports","Reports" );
		
	}
	public void clickAddButton() {
		applyImplicitWait();
		clickElement(AddButton,"AddButton");
			
	}
	public WebDriver clickEmailAndMyEmailSettingLink() {
		applyImplicitWait();
		clickElement(EmailButton,"EmailButton");
		ExplicitWaitforVisibility(MyEmailsettingButton, "MyEmailsettingButton");
		s.clickElement(MyEmailsettingButton,"MyEmail setting Button");
		return driver;
	}
	
	public void sendEmailSendEmailAddselectRadioBCCAndSelectSave(String emaildata, String emailaddressData) {
		s.cleartext(EmailTextBox);
		s.enterText(EmailTextBox, emaildata, "Email Name");
		s.cleartext(EmailAddress);
		s.enterText(EmailAddress, emailaddressData , "Email Address");
		s.clickElement(RadioAutomaticBcc, " Automatic BCC Radio Button");
		s.clickElement(SaveButton, "Save Button");
	}
	
	public WebDriver clickCalendarAndRemindersLinkAndSelectActivityReminders(){
		applyImplicitWait();
		clickElement(CalendarAndReminder,"CalendarAndReminder");
		ExplicitWaitforVisibility(ActivityReminder, "Activity Reminder");
		clickElement(ActivityReminder,"Activity Reminder Link");
		return driver;
	}
	
	   public void  clickOpenATestReminderButton() {
			applyImplicitWait();
			clickElement(OpenTestReminderButton,"Open A Test Reminder Button :");
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
