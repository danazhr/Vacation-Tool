package com.steps;

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
	public void click_approve_button(){
		inboxPage.click_approve_button();
	}
}
