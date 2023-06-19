package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class CustomizeMyTabPage extends BasePages {

	@FindBy(xpath="//select[@id='p4']")WebElement customAppdropdownEle;
	 @FindBy(id="p4")WebElement CustomAppDropDown;
	 @FindBy(id= "duel_select_0")WebElement AvailableTabsDropDown;
	 @FindBy(xpath="//input[@name='save']")WebElement SaveButton;
	  @FindBy(xpath="//img[@title='Add']")WebElement AddButton;
	
	public CustomizeMyTabPage(WebDriver driver) {
		super(driver);
		
	}
	public void selectSalesforceChatterFromDropDown() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(CustomAppDropDown, "Salesforce Chatter","Salesforce Chatter" );
		
	}
	public void selectWorkTypesFromDropDown() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(AvailableTabsDropDown, "Work Types","Work Types" );
		
	}
	public void clickAddButton() {
		applyImplicitWait();
		clickElement(AddButton,"AddButton");
			
	}
	
	public WebDriver clickSaveButton(){
		clickElement(SaveButton, "SaveButton");
		return driver;
	}
	
	
	

	
}
