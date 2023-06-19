package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class AccountsCreateNewViewPage extends BasePages {
	
	@FindBy(id="fname")WebElement ViewNameEditbox;
	@FindBy(id="devname")WebElement ViewUniqueName;
	@FindBy(xpath="//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]")WebElement SaveButtonForUniqueName;

	public AccountsCreateNewViewPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebDriver enterViewNameAndViewUniqueNameclickSave() {
		applyImplicitWait();
		cleartext(ViewNameEditbox);
		enterText(ViewNameEditbox, "Bhawna", "View Name Field");
		cleartext(ViewUniqueName);
		enterText(ViewUniqueName, "bhawnag", "View Unique Name");
		clickElement(SaveButtonForUniqueName,"Save button On Create New View");
		return driver;
		

  }
	
	public void changeViewName() {
		applyImplicitWait();
		cleartext(ViewNameEditbox);
		enterText(ViewNameEditbox, "Bhawna", "View Name Field");
}
	
   }
