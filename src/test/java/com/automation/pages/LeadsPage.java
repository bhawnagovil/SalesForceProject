package com.automation.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePages;

public class LeadsPage extends BasePages {
	
	public @FindBy(xpath= "//span[@id='userNavLabel']") WebElement UserMenuDropDown;
	public @FindBy(xpath= "//a[text()= 'Logout']")WebElement Logout;
	@FindBy(xpath="//input[@id='lexNoThanks']")WebElement NoThanksButton;
	@FindBy(xpath= "//select[@id='fcf']")WebElement ViewdropDown;
	@FindBy(xpath= "//input[@name='go']")WebElement GoButton;
	@FindBy(xpath= "//input[@name='new']")WebElement newbutton;
	@FindBy(xpath= "//input[@id='name_lastlea2']")WebElement lastnamefieldonleads;
	@FindBy(xpath= "//input[@id='lea3']")WebElement CompanyNamefiled;
	@FindBy(xpath= "//input[@name='save']")WebElement SaveButtonOnLeads;
	

	public LeadsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebDriver selectLogoutElementfromDropDown() {
		waitUntilElementIsClickable(UserMenuDropDown);
		selectinguserMenuDropDown();
		clickElementByJavaScriptExecutor(Logout);
		return driver;
	}
	
	public void clickNoThanksOnPopupWindowButton(){
		clickElementByJavaScriptExecutor(NoThanksButton);
		
	}
	public List<String> selectingViewDrpdownOptions() {
		Select select= new Select(ViewdropDown);
		List<WebElement>op= select.getOptions();
		List<String>optionelement= new ArrayList<String>();
		for(WebElement dropdown: op) {
			String options= dropdown.getText();
			optionelement.add(options);
		}
		return optionelement;
			
	}
	public void clickGoButton() {
	clickElementByJavaScriptExecutor(GoButton);	
	}
    
	public void selectingMyReadFromViewDropdown() {
		selectFromDropDownByVisibleText(ViewdropDown, "My Unread Leads", "My Unread Leads");
	}
	
	public void selectingTodayleadsViewDropdown() {
		selectFromDropDownByVisibleText(ViewdropDown, "Today's Leads", "Today's Leads");
	}
	
	public void clickNewButton(){
		clickElementByJavaScriptExecutor(newbutton);	
	}
	
	public void EnterlastnameEnterCompanyNameClicksave(String lastname, String companyname) {
		enterText(lastnamefieldonleads,lastname , "ABCD");
		enterText(CompanyNamefiled, companyname, "ABCD");
		clickElementByJavaScriptExecutor(SaveButtonOnLeads);
		
	}
	
	
}
