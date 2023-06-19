package com.automation.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class AccountsPage extends BasePages{
	
	
	@FindBy(id="createNewButton")WebElement CreateNewAccountButtonEle;
	@FindBy(xpath="//a[ text()= 'Account']")WebElement AccountFromdropdown;
	@FindBy(name= "save") WebElement SaveButtonForAccount;
	@FindBy(xpath="//a[text()='Create New View']")WebElement CreateNewViewLink;
	@FindBy(id="fcf")WebElement ViewSelectDropDown;
	@FindBy(xpath="//a[text()='Edit']")WebElement EditLink;
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[@name='goNext']")WebElement NextButton;
	@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")WebElement AccountWithLastActivityLink;
	@FindBy(xpath="//input[@id='lexNoThanks']")WebElement NoThanksButton;
	

	
	@FindBy(xpath="//a[text()='Merge Accounts']")WebElement MergeAccountLink;

	public AccountsPage(WebDriver driver) {
		super(driver);
		
	}
	public void clickNoThanksOnPopupWindowButton(){
		clickElementByJavaScriptExecutor(NoThanksButton);
		
	}
	
	
	public WebDriver clickMergeAccountLink() {
		clickElementByJavaScriptExecutor(MergeAccountLink);
		return driver;
		
	}
	
	public WebDriver selectingAccountFromCreateNewDropDown() {
		applyImplicitWait();
	    clickElementByJavaScriptExecutor(CreateNewAccountButtonEle);
	    clickElementByJavaScriptExecutor(AccountFromdropdown);
		return driver;
		
	}
	public void selectViewAccountFromDropDown() {
		selectFromDropDownByVisibleText(ViewSelectDropDown, "Bhawna"," ViewAccountDropDown");
	}
	
	public WebDriver clickSaveButton() {
		clickElement(SaveButtonForAccount, "Save Button");
		return driver;
	}
	
	public WebDriver clickNewViewLink() {
		clickElement(CreateNewViewLink, "Create New View link  on the Account Page");
		return driver;
		
	}

	
	public WebDriver clickEditLink() {
		clickElement(EditLink, "Edit link");
		return driver;
	}

	
	public void switchToMerGeAlertAndAccept() {
		waituntilAlertIsPresent();
	    Alert alert = 	switchToAlert();
	    alert.accept();
			
	}
	
	public WebDriver  clickAccountWithLastActivityLink() {
		applyImplicitWait();
		waitUntilElementIsClickable(AccountWithLastActivityLink);
		clickElementByJavaScriptExecutor(AccountWithLastActivityLink);	
	    return driver;
	
}
	
	

	  
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
