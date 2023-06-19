package com.automation.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ActivityRemainder;
import com.automation.pages.CustomizeMyTabPage;
import com.automation.pages.DeveloperConsolePage;
import com.automation.pages.EmailSettingPages;
import com.automation.pages.HomePages;
import com.automation.pages.LoginHistoryPages;
import com.automation.pages.MYProfilePages;
import com.automation.pages.MySettingpage;
import com.automation.pages.login.LoginPages;
import com.automation.utility.PropertiesUtility;

public class UserMenuDropDownTest extends BaseTest {

	public HomePages homepage;
	public LoginPages loginpage;
	public PropertiesUtility pro;
	public Properties appProp;
	public MYProfilePages myprofile;
	public MySettingpage mysetting;
	public DeveloperConsolePage developercs;
	public LoginHistoryPages loginhistory;
	public CustomizeMyTabPage customizemytab;
	public EmailSettingPages email;
	public ActivityRemainder acreminder;

	@Test
	public void checkIfUserMenuOptiondisplayedTest05() {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		homepage.selectinguserMenuDropDown();
		Assert.assertTrue(homepage.UserMenuDropDown.isDisplayed(), "User menu with options not displayed");

	}
	@Test
	public void checkingMYProfilePageFunctionality06() throws InterruptedException {	
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		myprofile= new MYProfilePages(driver);
		driver= myprofile.selectingMyPfoleFromHomePageDropDown();
		Thread.sleep(2000);
		myprofile.clickElementEditProfile();
		myprofile.SwitchingToEditProfilePopUp();
		myprofile.clickAboutTabButton();
		myprofile. EntertextinTheLasttNameEditBox("Govil");
		myprofile.clickSaveAllButton();
		driver.switchTo().defaultContent();
		//how to write the verify test if that entered test is displayed
		myprofile.clickingPostLink();
		myprofile.switchToPoStBoxFrameAndEnterTextAndcomingoutToShare("Hello Everyone");
		String relativefilePath= appProp.getProperty("PostLinkFilepath");
		myprofile.sendingFileAfterClickingFileLink(relativefilePath);
		applyImplicitWait();
		String imagefilepath= appProp.getProperty("ImageFilePath");
		myprofile.hoveringMouseOnprofileandAddPhoto(imagefilepath);	
		
	}
	@Test
	public void checkingMySettingPageFunctionality07() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		//mysetting= new MySettingpage(driver);
		driver= homepage. selectingMySettingFromHomePageDropDown();
		mysetting= new MySettingpage(driver);
		Thread.sleep(2000);
		driver= mysetting.clickPersonalLinkAndSelectDownLoadLoginHistory();
		loginhistory= new  LoginHistoryPages(driver);
		driver =loginhistory .clickDisplayAndLayoutLinkAnSelectCustomizeMyTab();
		customizemytab = new CustomizeMyTabPage(driver);
		customizemytab.selectSalesforceChatterFromDropDown();
		customizemytab.selectWorkTypesFromDropDown();
		customizemytab.clickAddButton();
		driver= customizemytab.clickSaveButton();
		mysetting= new MySettingpage(driver);
		driver= mysetting.clickEmailAndMyEmailSettingLink();
		email = new EmailSettingPages(driver);
		driver= email.sendEmailAndEmailAddressAddselectRadioBCCAndSelectSave("bhawnagovil","bhawna.govil@gmail.com");
		mysetting= new MySettingpage(driver);
		driver= mysetting.clickCalendarAndRemindersLinkAndSelectActivityReminders();	
		acreminder = new ActivityRemainder(driver);
		acreminder.clickOpenATestReminderButton();	
		
	}
	@Test
	public void checkingDeveloperConsoleFunctionality08(){
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		developercs = new DeveloperConsolePage(driver);
		driver= developercs.selectingDeveloperConsoleFromHomePageDropDown();
		developercs.ClosingDeveloperConsoleWindow();
			
	}
	
	@Test
	public void checkingLogoutFunctionalityFromHome09() throws InterruptedException{
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver= homepage.selectLogoutElementfromDropDown() ;
		Thread.sleep(2000);;
		loginpage= new LoginPages(driver);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
