package com.automation.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePages;

public class UnsaveReportSalesforcePage extends BasePages {
	

	@FindBy(id="ext-gen277")WebElement ToDayButtonInFromCalendar;
	@FindBy(id="ext-comp-1045")WebElement ToCalendarDateWidget;
	@FindBy(xpath="//img[@id='ext-gen152']")WebElement FromCalendarDateWidget;
	@FindBy(id="ext-gen309")WebElement ToDayButtonInToCalendar;
	@FindBy(id="ext-gen20")WebElement DateFieldDropDown;
	@FindBy(xpath="//div[text()='Created Date']")WebElement createddate;
	@FindBy(id="ext-gen49")WebElement SaveButtonOnUnSavedReport;
	@FindBy(id="saveReportDlg_reportNameField")WebElement SaveReportAlertReportNameEditBox;
	@FindBy(id="saveReportDlg_DeveloperName")WebElement UniqueReportNameEditBox;
	@FindBy(id="ext-gen280")WebElement PopUpSaveRunButton;
	@FindBy(id="ext-gen63")WebElement RunReportButton;
	
	
	public UnsaveReportSalesforcePage(WebDriver driver) {
		super(driver);
	}
			

	  public void selectingCreatedDateFromDropDownAndSelectingFromDate() {
		 applyImplicitWait();
		 clickElement(DateFieldDropDown, "Date Filed DropDown");
		 waitUntilElementIsClickable(createddate);
		 clickElement(createddate, "Create Date Field from dropDown");
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		 Date fromtoday = Calendar.getInstance().getTime();
		 String dateFrom = dateFormat.format(fromtoday);  
		     List<WebElement> columns=FromCalendarDateWidget.findElements(By.className("x-date-active"));

		     //comparing the text of cell with today's date and clicking it.
		     for (WebElement cell : columns)
		     {
		        if (cell.getText().equals(fromtoday))
		        {
		           cell.click();
		           break;
		        }
		     } 
		     
		     Date fromto = Calendar.getInstance().getTime();
			 String dateTo = dateFormat.format(fromto);  
			     List<WebElement> columnsToWidget =FromCalendarDateWidget.findElements(By.className("x-date-active"));

			     //comparing the text of cell with today's date and clicking it.
			     for (WebElement cell : columnsToWidget)
			     {
			        if (cell.getText().equals(fromto))
			        {
			           cell.click();
			           break;
			        }
			     } 
		     		     	 		  
	  }
	  
	  public WebDriver selectingCreateTodayDateFromDropDownAndSelectingTodayFromDateNew() {
		  applyImplicitWait();
			 clickElement(DateFieldDropDown, "Date Filed DropDown");
			 waitUntilElementIsClickable(createddate);
			 clickElement(createddate, "Create Date Field from dropDown"); 
			 clickElement(FromCalendarDateWidget, " From Calendar Widget");
			 waitUntilElementIsClickable(ToDayButtonInFromCalendar);
			 clickElement(ToDayButtonInFromCalendar, "TodayButtonInfromCalendarwidget");
			 waitUntilElementIsClickable(FromCalendarDateWidget);
			 clickElement(ToCalendarDateWidget, " To Calendar Widget");
			 waituntilElementIsSelectable(ToDayButtonInToCalendar, "Today Button In To Calendar");
			 clickElement(ToDayButtonInToCalendar, " ToDay Button In To Calendar Widget");
			 clickElement(ToCalendarDateWidget, " To Calendar Widget");
			 clickElement(SaveButtonOnUnSavedReport, "Save Button On Unsaved Report");	
			Alert alert=  switchToAlert();
			String messgae = alert.getText();
			log.info("messgae");
			enterText(SaveReportAlertReportNameEditBox, "TekReport", "PopUP ReportName");
			enterText(UniqueReportNameEditBox, "TekReportUnique", "PopUP Unique ReportName");
			clickElement(PopUpSaveRunButton, "Pop Up Save Button");
				return driver; 
		     
	  }
	  
	  public void clickRunReportButton() {
		  ExplicitWaitforVisibility(RunReportButton, "RunReport Button");
		  clickElement(RunReportButton, "RunReportButton");
	    
	  
}
}
