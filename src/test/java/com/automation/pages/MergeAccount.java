package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class MergeAccount extends BasePages{

	@FindBy(id="srch")WebElement MergeAccounEditBox;
	@FindBy(name= "srchbutton") WebElement FindAccountsButton;
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[@name='goNext']")WebElement NextButton;

	@FindBy(xpath="//input[@name='save']")WebElement MergeButtonOnMergeMYAccounnt;
	@FindBy(id="cid0")WebElement MergeAccountFirstCheckBox;
	@FindBy(id="cid1")WebElement MergeAccountSecondCheckBox ;
	@FindBy(name="save")WebElement MergeButtonstep2 ;
	
	
	public MergeAccount(WebDriver driver) {
		super(driver);
		
	}

	public void  sendtextToMergeAccountAndClickFindAccount(String text){
		applyImplicitWait();
		enterText(MergeAccounEditBox, text, "Merge Account EditBox");
		clickElement(FindAccountsButton, "FindAccountButton");
				
	}
	
	
	
	public void clickAccoubtsCheckBoxToMergeClickMerge() {
		if(!MergeAccountFirstCheckBox.isSelected()) {
			MergeAccountFirstCheckBox.click();
		}
		if(!MergeAccountSecondCheckBox.isSelected()) {
			MergeAccountSecondCheckBox.click();
		}
		clickElement(NextButton, "NextButton");
		clickElement(MergeButtonOnMergeMYAccounnt, "MergeButton On MergeMYAccount");
			
	}
	public void clickMergerAccount() {
		clickElement(MergeButtonstep2, "MergeButtonstep2");
		
	}
	
	public void switchingAfterMergeAlertAndAccept() {
	Alert alert= 	switchToAlert();
	alert.accept();
		
	}
	
}
