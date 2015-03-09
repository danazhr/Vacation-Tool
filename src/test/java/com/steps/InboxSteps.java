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
	public void click_inbox(){
		inboxPage.click_inbox();
	}
	

}
