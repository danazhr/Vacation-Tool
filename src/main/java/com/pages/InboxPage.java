package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class InboxPage extends PageObject {

	@FindBy(css = "li[class*='active-menu'] a[href*='menuItem=inbox']")
	public WebElementFacade inbox;

	@FindBy(css ="td[class*='rowChecker'] input")
	public List<WebElement> checkBoxes;
	
	@FindBy(css = "td[class*='employee-name']")
	public List<WebElement> names;
	
	@FindBy(css = "td[class*='start.date']")
	public List<WebElement> startDates;

	@FindBy(css = "td[class*='end.date']")
	public List<WebElement> endDates;
	
	@FindBy(css = "td[class*='day.number']")
	public List<WebElement> daysNumber;
	
	@FindBy(css = "td[class*='.type']")
	public List<WebElement> types;
			
	
	/*@FindBy(css = "input[value='Approve']")
	public WebElementFacade approveButton;*/
	
	@FindBy(css = "span[class*='aui-field-inline'] input[value='Approve']")
	public WebElementFacade approveButton;
	
	@FindBy(css = "div[class='action-buttons'] input[value='Reject']")
	public WebElementFacade rejectButtonPageInfo;
	
	@FindBy(xpath = "//div[@class='vacation-info-row align-to-left employee-info'][1]")
	public WebElementFacade employeeInfo;
	
	@FindBy(xpath = "//div[@class='vacation-info-row align-to-left employee-info'][2]")
	public WebElementFacade datesInfo;
	
	@FindBy(xpath = "//div[@class='vacation-info-row align-to-left employee-info'][3]")
	public WebElementFacade daysInfo;
	
	@FindBy(css = "span.header-back-to a")
	public WebElementFacade backButton;
	
	@FindBy(css = "div[class='portlet-msg-success']")
	public WebElementFacade successMsg;
		

	public void clickInbox() {
		inbox.waitUntilVisible();
		inbox.click();
	}

	public int getInboxRequestsNumber() {
		String numberOnly = inbox.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(numberOnly);
	}

	public int getTableRequestsNumber() {
		return startDates.size();
	}

	public void selectRequest(String employee, String startDate){
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){
						checkBoxes.get(i).click();
					}
				}
				break;
			}
		}
	}
	
	public void clickNameLinkFromTable(String employee, String startDate){
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){
						names.get(i).click();						
					}
				}
				break;
			}
		}
	}
	
	
	
	
	public void clickSpecificLinkToVerifyInfo(String employee, String startDate){
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){
						names.get(i).click();
						verifyInfoRequestByClicking(employee, startDate);
						backButton.click();
						
					}
				}
				break;
			}
		}
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){						
						startDates.get(i).click();
						verifyInfoRequestByClicking(employee, startDate);
						backButton.click();					
					}
				}
				break;
			}
		}
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){						
						endDates.get(i).click();
						verifyInfoRequestByClicking(employee, startDate);
						backButton.click();						
					}
				}
				break;
			}
		}
	}
	
	public void verifyInfoRequestByClicking(String name, String stDate){
		
		Assert.assertTrue("Not the same info!", employeeInfo.getText().contains(name) && datesInfo.getText().contains(stDate));
	
	}
	
	public void clickApproveButton(){
		approveButton.click();
	}


	public void checkIfSelectedRequestWasSubstracted(String employee,String startDate) {
		boolean found = false;
		for (WebElement name : names) {
			if (name.getText().contains(employee)) {
				for (int i = 0; i < startDates.size(); i++) {
					if (startDates.get(i).getText().contains(startDate)) {
						found = true;
					}
				}
				break;
			}
		}
		Assert.assertFalse("Request was found!", found);
	}
	
	public void checkIfSuccessMessageWasDisplayed(){
		Assert.assertTrue("Request not approved or rejected!", successMsg.isVisible() && successMsg.getText().contains("Your request completed successfully."));
	}
	
	
	
	public int calculateWorkdaysBetweenEndDateAndStartDate(String start, String end) throws ParseException {
		
		
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		List<Date> result = new ArrayList<Date>();
				
		Calendar c1 = GregorianCalendar.getInstance();
	    c1.setTime(sdfNew.parse(start));
	    Calendar c2 = GregorianCalendar.getInstance();
	    c2.setTime(sdfNew.parse(end));	    
	    
	    c2.add(Calendar.DAY_OF_YEAR, 1); //Add 1 day to endDate to make sure endDate is included into the final list
	    while (c1.before(c2)) {
	        result.add(c1.getTime());
	        c1.add(Calendar.DAY_OF_YEAR, 1);
	    }
	    System.out.println("Days between:" +"\n" +result );
	    System.out.println("Result size" + result.size());
	    int days = result.size();
	    for(int i = 0; i < result.size(); i++){
	    	Date day = result.get(i);
	    	if(day.toString().contains("Sat") || day.toString().contains("Sun")){
	    		days--;
		    }
	     }
	    System.out.println("Result list size: "+days);
	    
	    return days;    
	}
	
	public int getDaysNumberFromTable(String employee, String startDate){
		String d="";
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){
						d = daysNumber.get(i).getText();
					}
				}
				break;
			}
		}
			return Integer.parseInt(d);
	}
	
	public void clickRejectButtonFromPageInfo(){
		rejectButtonPageInfo.click();
	}
			
}
