
package com.automation.tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AccountsPage;
import com.automation.pages.HomePages;
import com.automation.pages.LeadsPage;
import com.automation.pages.login.LoginPages;
import com.automation.utility.PropertiesUtility;

public class LeadsTest extends BaseTest {

	public Properties appProp;
	public PropertiesUtility pro;
	public AccountsPage acpage;
	public LoginPages loginpage;
	public HomePages homepage;
	public LeadsPage leads;

	@Test
	public void checkLeadsLinkFunctionalityTest22() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickLeadsLink();
		Thread.sleep(3000);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		// System.out.println(driver.getTitle());
		// String TitleLeadsPage = driver.getTitle();
		leads = new LeadsPage(driver);
		// System.out.println(driver.getTitle());
		leads = new LeadsPage(driver);
		driver.switchTo().window(driver.getWindowHandle());
		String parentWindowhandler = driver.getWindowHandle();
		String lightiningpopup = "";
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			lightiningpopup = it.next();
		}
		driver.switchTo().window(lightiningpopup);
		System.out.println("switch to child window");
		leads = new LeadsPage(driver);
		leads.clickNoThanksOnPopupWindowButton();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindowhandler);
		System.out.println("Switched to parent window");
		Thread.sleep(2000);
		leads.selectLogoutElementfromDropDown();
		loginpage = new LoginPages(driver);

	}
  @Test
	public void validatingViewDropDownelementTest23() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickLeadsLink();
		Thread.sleep(3000);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		// System.out.println(driver.getTitle());
		// String TitleLeadsPage = driver.getTitle();
		leads = new LeadsPage(driver);
		// System.out.println(driver.getTitle());
		driver.switchTo().window(driver.getWindowHandle());
		String parentWindowhandler = driver.getWindowHandle();
		String lightiningpopup = "";
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			lightiningpopup = it.next();
		}
		driver.switchTo().window(lightiningpopup);
		System.out.println("switch to child window");
		leads = new LeadsPage(driver);
		leads.clickNoThanksOnPopupWindowButton();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindowhandler);
		System.out.println("Switched to parent window");
		Thread.sleep(3000);
		List<String> ExpextedViewdropdownlist = Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads",
				"Today's Leads", "View - Custom 1", "View - Custom 2");
		List<String> actualviewdropdown = leads.selectingViewDrpdownOptions();
		Assert.assertEquals(actualviewdropdown, ExpextedViewdropdownlist, "Dropdown elements are not matching");
		log.info("Elements match and test done");

	}
    @Test
     public void checkGoFunctionalityTest24() throws InterruptedException {
    	 log.info("*****************inside the login Page of salesForce application******************");
 		pro = new PropertiesUtility();
 		appProp = pro.loadFile("applicationDataProperties");
 		String userId = appProp.getProperty("login.valid.userid");
 		String password = appProp.getProperty("login.valid.password");
 		loginpage = new LoginPages(driver);
 		driver = loginpage.navigatingfromLoginToHome(userId, password);
 		homepage = new HomePages(driver);
 		log.info("****************inside the home page***********************");
 		driver = homepage.clickLeadsLink();
 		Thread.sleep(3000);
 		// Alert alert= switchToAlert();
 		// alert.dismiss();
 		// System.out.println(driver.getTitle());
 		// String TitleLeadsPage = driver.getTitle();
 		leads = new LeadsPage(driver);
 		// System.out.println(driver.getTitle());
 		driver.switchTo().window(driver.getWindowHandle());
 		String parentWindowhandler = driver.getWindowHandle();
 		String lightiningpopup = "";
 		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
 		Iterator<String> it = windows.iterator();
 		while (it.hasNext()) {
 			lightiningpopup = it.next();
 		}
 		driver.switchTo().window(lightiningpopup);
 		System.out.println("switch to child window");
 		leads = new LeadsPage(driver);
 		leads.clickNoThanksOnPopupWindowButton();
 		Thread.sleep(3000);
 		driver.switchTo().window(parentWindowhandler);
 		System.out.println("Switched to parent window");
 		Thread.sleep(3000);
 		leads.selectingMyReadFromViewDropdown();
 		Thread.sleep(4000);
 		driver= leads.selectLogoutElementfromDropDown();
 		Thread.sleep(3000);
 		loginpage = new LoginPages(driver);
 		password = appProp.getProperty("login.valid.password");
 		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickLeadsLink();
		Thread.sleep(3000);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		// System.out.println(driver.getTitle());
		// String TitleLeadsPage = driver.getTitle();
		leads = new LeadsPage(driver);
		// System.out.println(driver.getTitle());
		driver.switchTo().window(driver.getWindowHandle());
		 parentWindowhandler = driver.getWindowHandle();
	     lightiningpopup = "";
		 windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		 it = windows.iterator();
		while (it.hasNext()) {
			lightiningpopup = it.next();
		}
		driver.switchTo().window(lightiningpopup);
		System.out.println("switch to child window");
		leads = new LeadsPage(driver);
		leads.clickNoThanksOnPopupWindowButton();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindowhandler);
 		Thread.sleep(3000);
 		leads.clickGoButton();
 		    	 
     }
    @Test
    public void checkTodaysLeaddropdownButtonTest25() throws InterruptedException {
    	 log.info("*****************inside the login Page of salesForce application******************");
  		pro = new PropertiesUtility();
  		appProp = pro.loadFile("applicationDataProperties");
  		String userId = appProp.getProperty("login.valid.userid");
  		String password = appProp.getProperty("login.valid.password");
  		loginpage = new LoginPages(driver);
  		driver = loginpage.navigatingfromLoginToHome(userId, password);
  		homepage = new HomePages(driver);
  		log.info("****************inside the home page***********************");
  		driver = homepage.clickLeadsLink();
  		Thread.sleep(3000);
  		// Alert alert= switchToAlert();
  		// alert.dismiss();
  		// System.out.println(driver.getTitle());
  		// String TitleLeadsPage = driver.getTitle();
  		leads = new LeadsPage(driver);
  		// System.out.println(driver.getTitle());
  		driver.switchTo().window(driver.getWindowHandle());
  		String parentWindowhandler = driver.getWindowHandle();
  		String lightiningpopup = "";
  		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
  		Iterator<String> it = windows.iterator();
  		while (it.hasNext()) {
  			lightiningpopup = it.next();
  		}
  		driver.switchTo().window(lightiningpopup);
  		System.out.println("switch to child window");
  		leads = new LeadsPage(driver);
  		leads.clickNoThanksOnPopupWindowButton();
  		Thread.sleep(3000);
  		driver.switchTo().window(parentWindowhandler);
  		System.out.println("Switched to parent window");
  		Thread.sleep(3000);
  		leads.selectingTodayleadsViewDropdown();
  		Thread.sleep(2000);
  		leads.selectLogoutElementfromDropDown();
		loginpage = new LoginPages(driver);
  		
    }
    @Test
    public void checkToCreateNewlyLeadPage26() throws InterruptedException{
    	 log.info("*****************inside the login Page of salesForce application******************");
   		pro = new PropertiesUtility();
   		appProp = pro.loadFile("applicationDataProperties");
   		String userId = appProp.getProperty("login.valid.userid");
   		String password = appProp.getProperty("login.valid.password");
   		loginpage = new LoginPages(driver);
   		driver = loginpage.navigatingfromLoginToHome(userId, password);
   		homepage = new HomePages(driver);
   		log.info("****************inside the home page***********************");
   		driver = homepage.clickLeadsLink();
   		Thread.sleep(3000);
   		// Alert alert= switchToAlert();
   		// alert.dismiss();
   		// System.out.println(driver.getTitle());
   		// String TitleLeadsPage = driver.getTitle();
   		leads = new LeadsPage(driver);
   		// System.out.println(driver.getTitle());
   		driver.switchTo().window(driver.getWindowHandle());
   		String parentWindowhandler = driver.getWindowHandle();
   		String lightiningpopup = "";
   		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
   		Iterator<String> it = windows.iterator();
   		while (it.hasNext()) {
   			lightiningpopup = it.next();
   		}
   		driver.switchTo().window(lightiningpopup);
   		System.out.println("switch to child window");
   		leads = new LeadsPage(driver);
   		leads.clickNoThanksOnPopupWindowButton();
   		Thread.sleep(3000);
   		driver.switchTo().window(parentWindowhandler);
   		System.out.println("Switched to parent window");
   		Thread.sleep(2000);
   		leads.clickNewButton();
   		Thread.sleep(2000);
   		leads.EnterlastnameEnterCompanyNameClicksave("ABCD", "ABCD");
    }
    
    
    
    
    

}
