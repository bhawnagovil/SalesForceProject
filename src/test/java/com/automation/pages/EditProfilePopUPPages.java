package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class EditProfilePopUPPages extends BasePages {
	EditProfilePopUPPages edit;

	@FindBy(xpath= "//li[@id='aboutTab']")WebElement EditProfileAboutTabEle;
	@FindBy(xpath="//input[@id='lastName']")WebElement EditProfileLastNameEle;
	@FindBy(xpath= "//input[@value='Save All']")WebElement EditProfileSaveAllEle;
	@FindBy(id="city" )WebElement EditProfileCity;
	@FindBy(xpath="//input[@value='Cancel']" )WebElement EditProfileCancelEle;
	@FindBy(xpath="//li[@id='contactTab']")WebElement ContactButton;
	@FindBy(xpath= "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement EditProfileElement;
	String EditProfileframeid= "contactInfoContentId";
			
			
	public EditProfilePopUPPages(WebDriver driver) {
		super(driver);
		
	}
	
	public void clickAboutTabButton(){
		
		if(!EditProfileAboutTabEle.isSelected()) {
		clickElement(EditProfileAboutTabEle, "AboutTapButton");	
	}
	}
	
	public void EntertextinTheLasttNameEditBox(String text) {
		cleartext(EditProfileLastNameEle);
		enterText(EditProfileLastNameEle,text,"LastName Edit Box");
		
	}
	public void clickSaveAllButton() {
		clickElement(EditProfileSaveAllEle, "Save All Button");
	}
	
	public void SwitchingToEditProfilePopUp() {
		
		clickElement(EditProfileElement, "EditProfilePopUp");
		switchToFrame(EditProfileframeid);
		
	}
	
	

	
		
	
	
	

}
