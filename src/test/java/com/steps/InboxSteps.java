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
	public void go_to_inbox(){
		inboxPage.click_inbox();
	}
	
	@Step
	public int get_inbox_requests_number() {
		return inboxPage.get_inbox_requests_number();
	}

	@Step
	public int get_table_requests_number() {
		return inboxPage.get_table_requests_number();
	}

	@Step
	public void select_request(String employee, String startDate){
		inboxPage.select_request(employee, startDate);
	}
	
	@Step
	public int workdays_between_endDate_and_startDate(String start, String end) throws ParseException {
		return inboxPage.workdays_between_endDate_and_startDate( start, end);
	}
	

	@Step
	public void check_if_selected_request_was_approved(String employee, String startDate){
		inboxPage.check_if_selected_request_was_approved(employee, startDate);
	}
	
	@Step
	public void click_approve_button(){
		inboxPage.click_approve_button();
	}
	
	@Step
	public void check_if_number_of_workdays_is_correct(String start, String end, String employee) throws ParseException{
		Assert.assertEquals("Workdays number is not correct!", inboxPage.workdays_between_endDate_and_startDate(start, end), inboxPage.get_daysNumber_from_table(employee, start));
	}
	
	@Step
	public void click_specific_link_and_verify_info(String employee, String startDate){
		inboxPage.click_specific_link_and_verify_info(employee, startDate);
	}
}
