package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class ActivityRemainder extends BasePages {
	
	 @FindBy(id= "testbtn")WebElement OpenTestReminderButton;

	public ActivityRemainder(WebDriver driver) {
		super(driver);
		
	}
	
	 public void  clickOpenATestReminderButton() {
			applyImplicitWait();
			clickElement(OpenTestReminderButton,"Open A Test Reminder Button :");
			
		
	}

}
