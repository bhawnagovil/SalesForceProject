package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class AccountEditPage extends BasePages {

	@FindBy(id="acc2")WebElement AccountName;
	@FindBy(id= "acc6")WebElement TypeDropDown;
	@FindBy(id="00NHs00000Dku5r")WebElement CustomerPriorityDropDown;
	@FindBy(xpath="//input[@name='save']")WebElement SaveButton;
	@FindBy(id="fop1")WebElement OperatorDropDown;
	@FindBy(id="fval1")WebElement ValueEditBox;
	@FindBy(name= "save")WebElement SaveButtonForUniqueName;
	
	public AccountEditPage(WebDriver driver) {
		super(driver);
		
	}

	public WebDriver selectContainFromOperatorDropDownAndaddValueClickSave() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(OperatorDropDown,"contains" , "Contain option Operator dropdown");
		ExplicitWaitforVisibility(ValueEditBox, "Value edit box");
		enterText(ValueEditBox, "<a>", "Value edit box");
		clickElement(SaveButtonForUniqueName,"SaveButton");
		return driver;
	}
		
	
	public void SendingtextInAccountNameField(String text) {
		applyImplicitWait();
		cleartext(AccountName);
		enterText(AccountName, text, "Account Name");		
	}
	public void selectTechNologyParterFromTypeDropDown() {
		waituntilElementIsSelectable(TypeDropDown, "TypeDropDown");
		selectFromDropDownByVisibleText(TypeDropDown, "Technology Partner", "Technology partner option");
		
	}
	
	public void selectCustomerPriorityHighFromDropDown() {
		applyImplicitWait();
		selectFromDropDownByVisibleText(CustomerPriorityDropDown,"High" , "High Priority option");
	}
	public WebDriver clickSaveButton() {
		clickElement(SaveButton, "SaveButton");
		return driver;
	}

	
	
	

}
