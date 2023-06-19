package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class MYProfilePages extends BasePages {
	MYProfilePages profilepage;
	
	
	@FindBy(xpath= "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement EditProfileElement;
	@FindBy(xpath= "//a[@id='moderatorMutton']")
	WebElement EditProfiledropdownElementOther;
	@FindBy(id= "//a[@title='Edit Profile']") WebElement EditProfileOtherButtonFromDropdown;;
	@FindBy(id= "userNavLabel") WebElement UserMenuDropDown;
	@FindBy(xpath="//a[text()='My Profile']") WebElement MyProfileElement;
	@FindBy(xpath="//a[@id='publisherAttachContentPost']")WebElement FileLink;
	@FindBy(xpath="//span[text()='Share']")WebElement shareLinkUnderProfile;
	@FindBy(xpath="//span[text()='Post']")WebElement PostLink;
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")WebElement uploadFileLink;
	@FindBy(xpath="//input[@id='chatterFile']")WebElement ChooseFile;
	@FindBy(id ="username") WebElement userNameElement;
	@FindBy(id = "password") WebElement passwordElement;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id= "publisherAttachTextPost") WebElement PostElementLink;
	@FindBy(xpath="//a[@id='uploadLink']")WebElement AddPhoto;
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")WebElement ChooseFileAddPhoto;
	@FindBy(name="//input[@name='j_id0:uploadFileForm:save']")WebElement SavePhotoButtonEle;
	public @FindBy(xpath= "//li[@id='aboutTab']/a")WebElement EditProfileAboutTabEle;
	@FindBy(xpath= "//a/img[@title='Edit Profile'and @alt='Edit Profile']")WebElement EditProfilEle;
	@FindBy(xpath="//input[@id='lastName']")WebElement EditProfileLastNameEle;
	@FindBy(xpath= "//input[@value='Save All']")WebElement EditProfileSaveAllEle;
	@FindBy(id="city" )WebElement EditProfileCity;
	@FindBy(xpath="//input[@value='Cancel']" )WebElement EditProfileCancelEle;
	@FindBy(xpath="//li[@id='contactTab']")WebElement ContactButton;
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")WebElement iframePostboxElement;
	@FindBy(xpath="//body[@contenteditable='true']")WebElement PostBox;
	@FindBy(xpath="//input[@id='publishersharebutton']")WebElement ShareOutsideFrameToPost;
	
	String EditProfileframeid= "contactInfoContentId";
	
	
	
	public MYProfilePages(WebDriver driver) {
		super(driver);
		
	}
	
	public void selectinguserMenuDropDown() {
		applyImplicitWait();
		waitUntilElementIsClickable(UserMenuDropDown);
		clickElement(UserMenuDropDown, "UserMenuDropDown");
	}
	public WebDriver selectingMyPfoleFromHomePageDropDown() {
		selectinguserMenuDropDown();
		clickElement(MyProfileElement, "My Profile from userMenu");
		return driver;
	}
	
	public void sendingFileAfterClickingFileLink(String relativefilepath) {
		applyImplicitWait();
		clickElement(FileLink, "FileLink");
		clickElement(uploadFileLink, "UploadFileLink");
		enterTextToFile(ChooseFile,relativefilepath);
		clickElement(ShareOutsideFrameToPost, "Sharing file");
	}
	public void clickElementEditProfile() {
	clickElement(EditProfileElement, "EditProfileElement");	
	}
	
	public void SwitchingToEditProfilePopUp() {
		applyImplicitWait();
		driver.switchTo().frame(0)	;
	}
		
	
	
	public void clickEditProfile() {
		profilepage.clickElement(EditProfileElement, "EditProfileButton");
	}
	
	public void clickingPostLink() {
		clickElement(PostLink, "PostLink");
	}
	public void clickShareLink() {
		clickElement(shareLinkUnderProfile, "ShareLInk");
	}
	public void enteringTextinthePostarea() {
		switchToFrame(EditProfileframeid);
	}
	
	public void hoveringMouseOnprofileandAddPhoto(String relativephotofilepath) {
	   applyImplicitWait();
		profilepage.hoveringMouseToElement( AddPhoto);
		profilepage.ExplicitWaitforVisibility(ChooseFileAddPhoto,"chooseFileUploadLink");
		profilepage.clickElement(ChooseFileAddPhoto,"chooseFileUploadLink");
		enterTextToFile(ChooseFile,relativephotofilepath);
		
		clickElement(SavePhotoButtonEle,"SavePhotoButton");
		
	}
public void clickAboutTabButton(){
		
		//clickElement(EditProfileAboutTabEle, "AboutTapButton");	
		clickElementByJavaScriptExecutor(EditProfileAboutTabEle);
	
	}
	
	public void EntertextinTheLasttNameEditBox(String text) {
		cleartext(EditProfileLastNameEle);
		enterText(EditProfileLastNameEle,text,"LastName Edit Box");
		
	}
	public void clickSaveAllButton() {
		clickElement(EditProfileSaveAllEle, "Save All Button");
	}
	
	public void switchToPoStBoxFrameAndEnterTextAndcomingoutToShare(String Text) {
		applyImplicitWait();
		 driver.switchTo().frame(iframePostboxElement);
		 enterText(PostBox, Text, "PostBox");
		driver. switchTo().defaultContent();
		clickElement(ShareOutsideFrameToPost, "ShareButtonOutsidePostFrame");
			 
		 
	}
	
	
	
	

}
