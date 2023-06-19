package com.automation.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AccountsPage;
import com.automation.pages.CreateOpportunityPage;
import com.automation.pages.EditOpportunityPage;
import com.automation.pages.HomePages;
import com.automation.pages.OpportunityPipeLinePage;
import com.automation.pages.StuckOpportunityPage;
import com.automation.pages.login.LoginPages;
import com.automation.utility.PropertiesUtility;
import com.aventstack.extentreports.Status;

public class CreateOptyTest extends BaseTest {

	public Properties appProp;
	public PropertiesUtility pro;
	public AccountsPage acpage;
	public LoginPages loginpage;
	public HomePages homepage;
	public CreateOpportunityPage opportunity;
	public EditOpportunityPage editopportunity;
	public OpportunityPipeLinePage opportunitypipelinepage;
	public StuckOpportunityPage stuckopportunity;

	@Test
	public void ValidateOpportunityDropDownelementTest15() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickOpportunityLink();
		Thread.sleep(3000);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		opportunity = new CreateOpportunityPage(driver);
		String actualyopportynitypagetitile = driver.getTitle();
		System.out.println(actualyopportynitypagetitile);
		List<String> actualydropdownvalues = opportunity.getOpporunityDropDownOptionModel();
		log.info("Actual drop down content of the dropdown model is " + actualydropdownvalues);
		List<String> expectedopporunitydropdownvalues = Arrays.asList("Closing Next Month", "Closing This Month",
				"My Opportunities", "New This Week", "Recently Viewed Opportunities", "Won");
		Assert.assertEquals(actualydropdownvalues, expectedopporunitydropdownvalues,
				"opportunity dropdown does not have these values");

	}

	public void testUpdateOpportunityPage16() throws InterruptedException {
		log.info("*****************inside the login Page of salesForce application******************");
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		loginpage = new LoginPages(driver);
		driver = loginpage.navigatingfromLoginToHome(userId, password);
		homepage = new HomePages(driver);
		log.info("****************inside the home page***********************");
		driver = homepage.clickOpportunityLink();
		Thread.sleep(3000);
		// Alert alert= switchToAlert();
		// alert.dismiss();
		opportunity = new CreateOpportunityPage(driver);
		String actualyopportynitypagetitile = driver.getTitle();
		String expectedOpportunitytitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualyopportynitypagetitile, expectedOpportunitytitle);
		driver = opportunity.clickNewLink();
		editopportunity = new EditOpportunityPage(driver);
		System.out.println(driver.getTitle());
		editopportunity.enteringvalueineditopportunityNameAndAccount("Bhawna", "100");
		editopportunity.SelectStageAccountName();
		editopportunity.sendingdateToDateField();
		driver = editopportunity.clickSaveButton();
		opportunity = new CreateOpportunityPage(driver);

	}
	
	 public void testOpportunityPipelineVerificationTest17() throws InterruptedException {
		 log.info("*****************inside the login Page of salesForce application******************");
			pro = new PropertiesUtility();
			appProp = pro.loadFile("applicationDataProperties");
			String userId = appProp.getProperty("login.valid.userid");
			String password = appProp.getProperty("login.valid.password");
			loginpage = new LoginPages(driver);
			driver = loginpage.navigatingfromLoginToHome(userId, password);
			homepage = new HomePages(driver);
			log.info("****************inside the home page***********************");
			driver = homepage.clickOpportunityLink();
			Thread.sleep(3000);
			// Alert alert= switchToAlert();
			// alert.dismiss();
			opportunity = new CreateOpportunityPage(driver);
			String actualyopportynitypagetitile = driver.getTitle();
			String expectedOpportunitytitle = "Opportunities: Home ~ Salesforce - Developer Edition";
			Assert.assertEquals(actualyopportynitypagetitile, expectedOpportunitytitle);
			driver= opportunity.clickOpportunityPipeLink();
		    opportunitypipelinepage =  new 	OpportunityPipeLinePage(driver);
			System.out.println(driver.getTitle());
			
	 }
	 
	 public void teststuckOpportunityVerificationTest18() throws InterruptedException {
		 log.info("*****************inside the login Page of salesForce application******************");
			pro = new PropertiesUtility();
			appProp = pro.loadFile("applicationDataProperties");
			String userId = appProp.getProperty("login.valid.userid");
			String password = appProp.getProperty("login.valid.password");
			loginpage = new LoginPages(driver);
			driver = loginpage.navigatingfromLoginToHome(userId, password);
			homepage = new HomePages(driver);
			log.info("****************inside the home page***********************");
			driver = homepage.clickOpportunityLink();
			Thread.sleep(3000);
			// Alert alert= switchToAlert();
			// alert.dismiss();
			opportunity = new CreateOpportunityPage(driver);
			String actualyopportynitypagetitile = driver.getTitle();
			String expectedOpportunitytitle = "Opportunities: Home ~ Salesforce - Developer Edition";
			Assert.assertEquals(actualyopportynitypagetitile, expectedOpportunitytitle);
			driver= opportunity.clickStuckopportunityLink();
			 stuckopportunity = new  StuckOpportunityPage(driver);
			 System.out.println(driver.getTitle());
			 
			
		
	 }
	 
	 public void testQuarterySumeryLinkTest19() throws InterruptedException {
		 log.info("*****************inside the login Page of salesForce application******************");
			pro = new PropertiesUtility();
			appProp = pro.loadFile("applicationDataProperties");
			String userId = appProp.getProperty("login.valid.userid");
			String password = appProp.getProperty("login.valid.password");
			loginpage = new LoginPages(driver);
			driver = loginpage.navigatingfromLoginToHome(userId, password);
			homepage = new HomePages(driver);
			log.info("****************inside the home page***********************");
			driver = homepage.clickOpportunityLink();
			Thread.sleep(3000);
			// Alert alert= switchToAlert();
			// alert.dismiss();
			opportunity = new CreateOpportunityPage(driver);
			String actualyopportynitypagetitile = driver.getTitle();
			String expectedOpportunitytitle = "Opportunities: Home ~ Salesforce - Developer Edition";
			Assert.assertEquals(actualyopportynitypagetitile, expectedOpportunitytitle);
			
	 }
	 
	 
	
	

}
