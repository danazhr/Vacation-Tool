package com.steps;

import java.text.ParseException;

import org.junit.Assert;

import com.pages.InboxPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class InboxSteps extends ScenarioSteps{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688955740311718779L;
	InboxPage inboxPage;
	
	@Step
	public void goToInbox(){
		inboxPage.clickInbox();
	}
	
	@Step
	public int getInboxRequestsNumber() {
		return inboxPage.getInboxRequestsNumber();
	}

	@Step
	public int getTableRequestsNumber() {
		return inboxPage.getTableRequestsNumber();
	}

	@Step
	public void selectRequest(String employee, String startDate){
		inboxPage.selectRequest(employee, startDate);
	}
	
	@Step
	public int calculateWorkdaysBetweenEndDateAndStartDate(String start, String end) throws ParseException {
		return inboxPage.calculateWorkdaysBetweenEndDateAndStartDate( start, end);
	}
	

	@Step
	public void checkIfSelectedRequestWasApproved(String employee, String startDate){
		inboxPage.checkIfSelectedRequestWasApproved(employee, startDate);
	}
	
	@Step
	public void clickApproveButton(){
		inboxPage.clickApproveButton();
	}
	
	@Step
	public void checkIfNumberOfWorkdaysIsCorrect(String start, String end, String employee) throws ParseException{
		Assert.assertEquals("Workdays number is not correct!", inboxPage.calculateWorkdaysBetweenEndDateAndStartDate(start, end), inboxPage.getDaysNumberFromTable(employee, start));
	}
	
	@Step
	public void clickSpecificLinkToVerifyInfo(String employee, String startDate){
		inboxPage.clickSpecificLinkToVerifyInfo(employee, startDate);
	}
}
