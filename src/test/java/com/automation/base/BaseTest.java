package com.automation.base;

import java.util.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.automation.utility.PropertiesUtility;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class BaseTest extends PropertiesUtility {
	
	 public  WebDriver driver;
	 public WebDriverWait wait;
	 public  Logger log;
	 
	
	
	@BeforeTest
	public void setUpBeforeTest() {
		log= (Logger) LogManager.getLogger(BaseTest.class.getName());
	}
	
	
	    @BeforeMethod
	    public void setUpBeforeTestMethod() {
		PropertiesUtility pro= new PropertiesUtility();
		Properties propfile  = pro.loadFile("applicationDataProperties");
		LaunchBrowswe("chrome");
		String url= propfile.getProperty("Loginurl");
		getURL(url);
		System.out.println("url :"+ url);		
		log.info("url entered in the Address box");
		
	}
	
	@AfterMethod
	public void setUpAfterTestMethod() {
	driver.close();	
	}
		
	    public void LaunchBrowswe(String browsername){
	        switch(browsername){
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver= new FirefoxDriver();
	                driver.manage().window().maximize();
	                break;
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                ChromeOptions option = new ChromeOptions();
	                option.addArguments("--remote-allow-origins=*");
	                 driver = new ChromeDriver(option);
	                driver.manage().window().maximize();
	                break;
	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver= new EdgeDriver();
	                driver.manage().window().maximize();
	                break;

	        }

	       log.info(browsername+ "is opened");
	    }

	    public void getURL(String url){
	        driver.get(url);
	        log.info("url enetered in the url field");

	    }


	    public void  applyImplicitWait(){
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    }
	   
	    public  void waituntilAlertIsPresent() {
	        log.info("waiting for alert to be present");
	        wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.alertIsPresent());
	    }

	    public  void waitUntilElementIsClickable(WebElement element) {
	        System.out.println("waiting for element to be clickable");
	        wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	    }

	    public void waituntilElementIsSelectable(WebElement element, String obj) {
	        log.info("waiting for Element to get selected ");
	        wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.elementToBeSelected(element));
	    }

	    public void fluentWaitforVisibility(WebElement element) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(5));
	                //.ignoring(NoSuchElementException.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    public  void ExplicitWaitforVisibility(WebElement element, String obj){
	       log.info("waiting for" + obj+ "to be visible");
	        wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        
	    }

	    public  void ElementNoInteractable(WebElement element){
	      log.info("wait until element is interacatable");
	        wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	    }

	    public Alert switchToAlert() {
	        waituntilAlertIsPresent();
	        Alert alert = driver.switchTo().alert();
	        log.info("Switched to alert");
	        return alert;
	    }
	    
	    public void AcceptAlert(Alert alert) {
	    	alert.accept();
	    	
	    }
	    
	    
	    public String getAlertText(Alert alert){
	    	
	    	String alerttext= alert.getText();
	    	return alerttext;
	    		
	    	
	    }

	    
	    public void refreshpage(){
	        driver.navigate().refresh();
	    }

	    public void performDragAndDropbyHolding(WebElement from, WebElement target){
	        Actions action= new Actions( driver);
	        action.clickAndHold(from).moveToElement(target).release().build().perform();
	    }

	    public String  getTitleofPage(WebDriver driver){
	    	this.driver= driver;
	        String title=driver.getTitle();
	        return title;

	    }
	    
	   

	    public  WebDriver setBehaviourToPassHTTPThroughOptionClass(){
	        LaunchBrowswe("chrome");
	        ChromeOptions options= new ChromeOptions();
	        options.setAcceptInsecureCerts(true);
	        driver= new ChromeDriver(options);
	        return driver;
	    }
	    public void takeScreenShot( WebDriver driver,String filepath)  {
	        TakesScreenshot screenshot= (TakesScreenshot) driver;
	        File srcfile= screenshot.getScreenshotAs(OutputType.FILE);
	        File destFile= new File(filepath);
	        try {
	            FileUtils.copyFile(srcfile,destFile);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    
	  
	   

	    public  void checkBrokenLink (String weburl, List<WebElement>links)throws IOException {
	        //broken URL
	        //Step 1 - IS to get all urls tied up to the links using Selenium
	        //  Java methods will call URL's and gets you the status code
	        //if status code >400 then that url is not working-> link which tied to url is broken
	        //a[href*="soapui"]'
	        getURL(weburl);
	         //links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	        SoftAssert a = new SoftAssert();
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	            conn.setRequestMethod("HEAD");
	            conn.connect();
	            int respCode = conn.getResponseCode();
	            log.info(respCode);
	            a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);
	        }
	        a.assertAll();




	    }


}
