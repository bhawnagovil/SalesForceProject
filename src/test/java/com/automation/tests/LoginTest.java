package com.automation.tests;

import java.util.Properties;
import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.PropertiesUtility;

public class LoginTest extends BaseTest{
	public HomePage home;
	public LoginPage loginpage;
	public LoginTest test;
	public PropertiesUtility pro;
	public Properties appProp;
	
	@Test
	private void valiadateLoginPageDisplayedAndValidatePageTitle() {
		log.info("inside the login Page of salesForce application");
		 pro=new PropertiesUtility();
		 System.out.println("entering into application data properties");
		 appProp= pro.loadFile("applicationDataProperties");
		 System.out.println(appProp.getProperty("Loginurl"));
		String expectedpagetitle= appProp.getProperty("loginPageTitle");
		LoginPage loginPage=new LoginPage(driver);
		String actulTitle=test.getTitleofPage();
		Assert.assertEquals(actulTitle,expectedpagetitle, "actual and expected title are not matching");
		log.info("Login page title is correct and displayed");
	}
	
	@Test
	private void validateErrorMessageWhenPasswordFieldempty() {
		log.info("inside the login Page of salesForce application");		
		 pro=new PropertiesUtility();
		 appProp= pro.loadFile("applicationDataProperties");
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		 loginpage=new LoginPage(driver);
		loginpage.clearAllTextuseranme();
		loginpage.enterUsername(userId);
		loginpage.clickLoginButton();
		String actualError= loginpage.getErrorTest();
		String expectedError=appProp.getProperty("login.valid.error1");
		Assert.assertEquals(actualError, expectedError, "actual and expected errors are not matching");
		log.info("Actual error is matching with the expected error");
	}
	
	@Test
	private void validateHomePageDisplayed() {
		 test= new LoginTest();
		log.info("inside the login Page of salesForce application");
		 pro=new PropertiesUtility();
		 appProp= pro.loadFile("applicationDataProperties");
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		loginpage=new LoginPage(driver);
		driver=loginpage.navigatingfromLoginToHome(userId,password);
		home= new HomePage(driver);
		String actualTitle=test.getTitleofPage();
		String expectedTitle= appProp.getProperty("login.valid.HomePageTitle");
		Assert.assertEquals(actualTitle, expectedTitle, "expected and actual titles are not matching");	
		log.info("Actual title matching with the expected title");
		
	}
	@Test
	private void checkIfUserNamePopulatedAfterLogOutHomePage() {
		log.info("inside the HomePage of salesForce application");		
		 pro=new PropertiesUtility();
		 appProp= pro.loadFile("applicationDataProperties");
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		loginpage=new LoginPage(driver);
		loginpage.navigatingfromLoginToHome(userId,password);
		 home= new HomePage(driver);
		home.selectElementfromDropDown("Logout");
		//loginpage.checkifUsernameisPopulated(userId);
		Assert.assertTrue(loginpage.checkifUsernameisPopulated(userId),"username field is not populated");
		log.info("test passed username field is populated");

	}
	
	@Test
	private void checkIfRememberMecheckBoxIsChecked() {
		    test= new LoginTest();
			log.info("checking if remeber me checkbox is checked");
			 pro=new PropertiesUtility();
			 appProp= pro.loadFile("applicationDataProperties");
			String userId=appProp.getProperty("login.valid.userid");
			String password=appProp.getProperty("login.valid.password");
			loginpage.navigatingfromLoginToHome(userId,password);
			home= new HomePage(driver);
			home.selectElementfromDropDown("Logout");
			Assert.assertTrue(loginpage.checkIfCheckBoxselected(),"Remember me checkbox is not selected");
		    log.info("Remeber me checkbox is checked if selected or not");	    
	}
	
	@Test
	private void checkErrorMsgwhenWrongUserNameAndPaSSWORDEntered() {
		log.info("Checking Error meassage when wrong username and password entered");
		 pro=new PropertiesUtility();
		 appProp= pro.loadFile("applicationDataProperties");
		 String WronguserId=appProp.getProperty("login.invalid.userid");
		 String wrongPassword= appProp.getProperty("login.invalid.password");
		 loginpage.navigatingfromLoginToHome(WronguserId,wrongPassword);
		 String actualerror= loginpage.getErrorTest();
		 String expectedError= appProp.getProperty("login.valid.error1");
		 Assert.assertEquals(actualerror, expectedError, "errortext is not matching");
			
		
	}
	
	
	
	
	
}
	
	
	

	
