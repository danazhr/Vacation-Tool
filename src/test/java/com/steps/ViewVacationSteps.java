package com.steps;

import com.pages.ViewVacationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ViewVacationSteps extends ScenarioSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9070981813057372079L;
	
	ViewVacationPage viewVacationPage;
	
	@Step
	public void go_to_viewVacations(){
	viewVacationPage.click_viewVacations();
	}
	
	@Step
	public void set_days_number_filter(String interval){
		viewVacationPage.set_days_number_filter(interval);
	}
	
	@Step
	public void click_apply(){
		viewVacationPage.click_apply();
	}
}
