package com.automation.tests;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AccountEditPage;
import com.automation.pages.AccountsCreateNewViewPage;
import com.automation.pages.AccountsPage;
import com.automation.pages.HomePages;
import com.automation.pages.MergeAccount;
import com.automation.pages.UnsaveReportSalesforcePage;
import com.automation.pages.login.LoginPages;
import com.automation.utility.PropertiesUtility;

public class AccountTest extends BaseTest {

	public Properties appProp;
	public PropertiesUtility pro;
	public AccountsPage acpage;
	public LoginPages loginpage;
	public HomePages homepage;
	public AccountEditPage editpage;
	public AccountsCreateNewViewPage createnewview;
	public MergeAccount merge;
	public UnsaveReportSalesforcePage unsavereport;

	@Test
	public void checkAccountPageDisplayedWithAccountDetailsTest10() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickAccountTab();
		String beforetitle = driver.getTitle();
		System.out.println(beforetitle);
		Thread.sleep(6000);
		 driver.switchTo().window(driver.getWindowHandle());
		 String parentWindowhandler= driver.getWindowHandle();
		String lightiningpopup= "";
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        while(it.hasNext()) {
        	lightiningpopup= it.next();
        }
        driver.switchTo().window(lightiningpopup);
        System.out.println("switch to child window");
        acpage = new AccountsPage(driver);
        acpage.clickNoThanksOnPopupWindowButton();
        driver.switchTo().window(parentWindowhandler);  
        System.out.println("Switched to parent window");
        
		driver = acpage.selectingAccountFromCreateNewDropDown();
		Thread.sleep(3000);
		editpage = new AccountEditPage(driver);
		editpage.SendingtextInAccountNameField("Bhawna");
		Thread.sleep(2000);
		editpage.selectTechNologyParterFromTypeDropDown();
		editpage.selectCustomerPriorityHighFromDropDown();
		driver = editpage.clickSaveButton();
		acpage = new AccountsPage(driver);
		driver = acpage.selectingAccountFromCreateNewDropDown();
		editpage = new AccountEditPage(driver);
		editpage.SendingtextInAccountNameField("Bhawna G");
		editpage.selectTechNologyParterFromTypeDropDown();
		editpage.selectCustomerPriorityHighFromDropDown();
		driver = editpage.clickSaveButton();
		String aftertitle = driver.getTitle();
		System.out.println(aftertitle);

	}
	
	public void switchingToLighningPOpUpClickNOThanksVomeBackToParentWindow() {
		  Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
	        Iterator<String> it = windows.iterator();
	        String parentId = it.next();
	        String childId = it.next();
	        driver.switchTo().window(childId);
	        acpage = new AccountsPage(driver);
	        acpage.clickNoThanksOnPopupWindowButton();
	        driver.switchTo().window(parentId);
	        
	}
  @Test
	public void checkfunctionalityCreateNewViewLinkTest11() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickAccountTab();
		acpage = new AccountsPage(driver);
		Thread.sleep(6000);
		 driver.switchTo().window(driver.getWindowHandle());
		 String parentWindowhandler= driver.getWindowHandle();
		String lightiningpopup= "";
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
      Iterator<String> it = windows.iterator();
      while(it.hasNext()) {
      	lightiningpopup= it.next();
      }
      driver.switchTo().window(lightiningpopup);
      System.out.println("switch to child window");
      acpage = new AccountsPage(driver);
      acpage.clickNoThanksOnPopupWindowButton();
      driver.switchTo().window(parentWindowhandler);  
      System.out.println("Switched to parent window");
      
		driver = acpage.clickNewViewLink();
		createnewview = new AccountsCreateNewViewPage(driver);
		driver = createnewview.enterViewNameAndViewUniqueNameclickSave();
		acpage = new AccountsPage(driver);

	}
   @Test
	public void checkNewviewNameFuctinality12() throws InterruptedException {

		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickAccountTab();
		acpage = new AccountsPage(driver);
		String currentpagetitle = driver.getTitle();
		System.out.println(currentpagetitle);
		Thread.sleep(6000);
		 driver.switchTo().window(driver.getWindowHandle());
		 String parentWindowhandler= driver.getWindowHandle();
		String lightiningpopup= "";
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
       Iterator<String> it = windows.iterator();
       while(it.hasNext()) {
       	lightiningpopup= it.next();
       }
       driver.switchTo().window(lightiningpopup);
       System.out.println("switch to child window");
       acpage = new AccountsPage(driver);
       acpage.clickNoThanksOnPopupWindowButton();
       driver.switchTo().window(parentWindowhandler);  
       System.out.println("Switched to parent window");
       
		acpage.selectViewAccountFromDropDown();
		driver = acpage.clickEditLink();
		editpage = new AccountEditPage(driver);
		String TitleEditviewPage = driver.getTitle();
		System.out.println(TitleEditviewPage);
		editpage.SendingtextInAccountNameField("Bhawna");
		driver = editpage.selectContainFromOperatorDropDownAndaddValueClickSave();
		acpage = new AccountsPage(driver);
	}

	@Test
	public void checkMergeAccountFunctionality13() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickAccountTab();
		String expectedtitle = " Home ~ Salesforce - Developer Edition";
		String accountpageactualtitle = driver.getTitle();
		System.out.println(accountpageactualtitle);
		Assert.assertEquals(accountpageactualtitle, expectedtitle);
		acpage = new AccountsPage(driver);
		Thread.sleep(2000);
		Thread.sleep(6000);
		 driver.switchTo().window(driver.getWindowHandle());
		 String parentWindowhandler= driver.getWindowHandle();
		String lightiningpopup= "";
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
      Iterator<String> it = windows.iterator();
      while(it.hasNext()) {
      	lightiningpopup= it.next();
      }
      driver.switchTo().window(lightiningpopup);
      System.out.println("switch to child window");
      acpage = new AccountsPage(driver);
      acpage.clickNoThanksOnPopupWindowButton();
      driver.switchTo().window(parentWindowhandler);  
      System.out.println("Switched to parent window");
      
		driver = acpage.clickMergeAccountLink();
		Thread.sleep(2000);
		merge = new MergeAccount(driver);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		// String actualMergeAcoountpagetile= driver.getTitle();
		merge.sendtextToMergeAccountAndClickFindAccount("Bhawna G");
		merge.sendtextToMergeAccountAndClickFindAccount("Bhawna");
		merge.clickAccoubtsCheckBoxToMergeClickMerge();
		System.out.println(driver.getTitle());
		merge.clickMergerAccount();

	}

	@Test
	public void checkReportPageWithDetailDisplayed14() throws InterruptedException {

		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickAccountTab();
		acpage = new AccountsPage(driver);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		Thread.sleep(6000);
		 driver.switchTo().window(driver.getWindowHandle());
		 String parentWindowhandler= driver.getWindowHandle();
		String lightiningpopup= "";
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
      Iterator<String> it = windows.iterator();
      while(it.hasNext()) {
      	lightiningpopup= it.next();
      }
      driver.switchTo().window(lightiningpopup);
      System.out.println("switch to child window");
      acpage = new AccountsPage(driver);
      acpage.clickNoThanksOnPopupWindowButton();
      driver.switchTo().window(parentWindowhandler);  
      System.out.println("Switched to parent window");
      
		driver = acpage.clickAccountWithLastActivityLink();
		unsavereport = new UnsaveReportSalesforcePage(driver);
		String Unsavereportactualtitle = driver.getTitle();
		System.out.println(Unsavereportactualtitle);
		driver = unsavereport.selectingCreateTodayDateFromDropDownAndSelectingTodayFromDateNew();
		String NewReportPageTitle = driver.getTitle();
		System.out.println(NewReportPageTitle);

	}

}
