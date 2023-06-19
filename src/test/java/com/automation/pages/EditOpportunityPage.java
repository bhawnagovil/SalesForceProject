package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class EditOpportunityPage extends BasePages{
	

	@FindBy(xpath = "//input[@id='opp3']")
	WebElement OpportunityNameEle;

	@FindBy(xpath = "//input[@id='opp4']")
	WebElement OpportunityAccountNameEle;

	@FindBy(xpath = "//input[@id='opp7']")
	WebElement OpportunityAmountEle;

	@FindBy(xpath = "//input[@name='save']")
	WebElement OpportunitysaveButton;
	
	@FindBy(xpath = "//input[@id='opp9']")
	WebElement OpportunityDate;
	
	@FindBy(xpath = "//select[@id='opp11']")
	WebElement OpportunitySelectStage;
	
	public EditOpportunityPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void enteringvalueineditopportunityNameAndAccount(String OpportunityName, String amount) {
		enterText(OpportunityNameEle,OpportunityName, "OpportunityName");
		OpportunityAmountEle.sendKeys(amount);
		
	}
	
	public void SelectStageAccountName() {
		selectFromDropDownByVisibleText(OpportunitySelectStage,"Qualification", "Qualification from dropdown");
		selectFromDropDownByVisibleText(OpportunityAccountNameEle,"Bhawna", "Bhawna from dropdown");
	}
	
	public void sendingdateToDateField() {
		OpportunityDate.sendKeys("6/17/2023");
	}
	
	public WebDriver clickSaveButton() {
		
		clickElement(OpportunitysaveButton, "OpportunitysaveButton");
		return driver;
	}
	
	
	
	
	

}
