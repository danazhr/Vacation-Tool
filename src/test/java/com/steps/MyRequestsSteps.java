package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyReqPage;

public class MyRequestsSteps extends ScenarioSteps {
	
	MyReqPage reqPage;
		
	@Step
	public void set_vacation_type(String checks) {
		reqPage.set_vacation_type(checks);
	}
	
	@Step
	public void set_daysnumber_type(String checks) {
		reqPage.set_daysnumber_type(checks);
	}
	@Step
	public void set_vacationstatus_type(String checks) {
		reqPage.set_vacationstatus_type(checks);
	}
	@Step
	public void click_apply_filter_button(){
		reqPage.click_apply_filter_button();
	}
}
