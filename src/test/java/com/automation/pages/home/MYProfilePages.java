package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class MYProfilePages extends BasePages {
	MYProfilePages profilepage;
	
	
	@FindBy(xpath= "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement EditProfileElement;
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	@FindBy(xpath="//a[@id='publisherAttachContentPost']")WebElement FileLink;
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")WebElement uploadFileLink;
	@FindBy(xpath="//input[@id='chatterFile']")WebElement ChooseFile;
	@FindBy(id ="username") WebElement userNameElement;
	@FindBy(id = "password") WebElement passwordElement;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id= "publisherAttachTextPost") WebElement PostElementLink;
	@FindBy(xpath="//a[@id='uploadLink']")WebElement AddPhoto;
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")WebElement ChooseFileAddPhoto;
	@FindBy(name="//input[@name='j_id0:uploadFileForm:save']")WebElement SavePhotoButtonEle;
	@FindBy(xpath= "//li[@id='aboutTab']")WebElement EditProfileAboutTabEle;
	@FindBy(xpath="//input[@id='lastName']")WebElement EditProfileLastNameEle;
	@FindBy(xpath= "//input[@value='Save All']")WebElement EditProfileSaveAllEle;
	@FindBy(id="city" )WebElement EditProfileCity;
	@FindBy(xpath="//input[@value='Cancel']" )WebElement EditProfileCancelEle;
	@FindBy(xpath="//li[@id='contactTab']")WebElement ContactButton;
	String EditProfileframeid= "contactInfoContentId";
	
	public MYProfilePages(WebDriver driver) {
		super();
		
	}
	
	public WebDriver selectingMyPfoleFromHomePageDropDown() {
		profilepage.navigatingfromLoginToHome("usertext","passwordtext");
		selectOptionFromDropDownByVisibleText(UserMenuDropDown,"My Profile", "My Profile Option");	
		return driver;
	}
	
	public void sendingFileAfterClickingFileLink(String relativefilepath) {
		applyImplicitWait();
		clickElement(FileLink, "FileLink");
		clickElement(uploadFileLink, "UploadFileLink");
		enterTextToFile(ChooseFile,relativefilepath);	
	}
	
	public void SwitchingToEditProfilePopUp() {
		if(!EditProfileElement.isSelected()) {
		clickElement(EditProfileElement, "EditProfilePopUp");}
		else {
		switchToFrame(EditProfileframeid);
	}
		
	}
	
	public void clickEditProfile() {
		profilepage.clickElement(EditProfileElement, "EditProfileButton");
	}
	
	public void clickingPostLink() {
		
	}
	
	public void hoveringMouseOnprofileandAddPhoto(String relativefilepath) {
		profilepage.hoveringMouseToElement( AddPhoto);
		profilepage.ExplicitWaitforVisibility(ChooseFileAddPhoto,"chooseFileUploadLink");
		profilepage.clickElement(ChooseFileAddPhoto,"chooseFileUploadLink");
		enterTextToFile(ChooseFile,relativefilepath);
		clickElement(SavePhotoButtonEle,"SavePhotoButton");
		
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
	
	
	
	

}
