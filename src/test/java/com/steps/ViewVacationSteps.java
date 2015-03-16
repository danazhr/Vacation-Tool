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
	public void goToViewVacations(){
	viewVacationPage.clickViewVacations();
	}
	
	@Step
	public void setDaysNumberFilter(String interval){
		viewVacationPage.setDaysNumberFilter(interval);
	}
	
	@Step
	public void setLastNameFilter(String lastname){
		viewVacationPage.setLastNameFilter(lastname);
	}
	
	@Step
	public void checkIfFilterLastnameAppliedForTable(String lastname){
		viewVacationPage.checkIfFilterLastnameAppliedForTable(lastname);
	}
	
	@Step
	public void clickApply(){
		viewVacationPage.clickApply();
	}
	
	public void clickDaysNumberHeaderToSort(){
		viewVacationPage.clickDaysNumberHeader();
		
	}
	
	@Step
	public void checkSortDays() throws Exception{
		viewVacationPage.checkSortDays();
	}
	
}
