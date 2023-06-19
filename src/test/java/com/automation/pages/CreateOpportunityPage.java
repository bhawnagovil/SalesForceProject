package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePages;

public class CreateOpportunityPage extends BasePages {

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement AllOpportunityDropDown;
	@FindBy(xpath = "//input[@name='new']")
	WebElement newlinkToEditopportunity;
	@FindBy(xpath = "//a[text()= 'Opportunity Pipeline']")
	WebElement OpportunityPipeLineLink;
	
	@FindBy(xpath = "//a[text()= 'Stuck Opportunities']")
	WebElement StuckOpportunityLink;
	
	
	
	

	public CreateOpportunityPage(WebDriver driver) {
		super(driver);

	}
	 

	public List<String> getOpporunityDropDownOptionModel() {
		applyImplicitWait();
		switchToHometopopupWindowAndClose();
		waituntilElementIsSelectable(AllOpportunityDropDown, "All OpportunityDropDown");
		Select select = new Select(AllOpportunityDropDown);
		List<WebElement> listOpoorunitydropdownoption = select.getOptions();
		List<String> actualcontent = new ArrayList<String>();
		for (WebElement dropdownacelement : listOpoorunitydropdownoption) {
			actualcontent.add(dropdownacelement.getText());

		}
		return actualcontent;

	}
  
	public WebDriver clickNewLink() {
		waitUntilElementIsClickable(newlinkToEditopportunity);
		clickElementByJavaScriptExecutor(newlinkToEditopportunity);
		return driver;
	}

	public WebDriver clickOpportunityPipeLink() {
		waitUntilElementIsClickable(OpportunityPipeLineLink);
		clickElementByJavaScriptExecutor(OpportunityPipeLineLink);
		return driver;
	}
	public WebDriver clickStuckopportunityLink() {
		waitUntilElementIsClickable(StuckOpportunityLink);
		clickElementByJavaScriptExecutor(StuckOpportunityLink);
		return driver;
	}
	
	
}
