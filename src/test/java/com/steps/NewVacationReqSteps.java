package com.steps;

import java.text.ParseException;

import com.pages.NewVacationReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationReqSteps extends ScenarioSteps {

	NewVacationReqPage newVacationRequest;

	@Step
	public void click_newVacationReq() {
		newVacationRequest.go_to_new_request();
	}

	@Step
	public int get_businessDaysOutput() {
		//return newVacationRequest.get_businessDaysOutput();
		return 1;
	}
	
		
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setStartDate(String date) throws ParseException{
		newVacationRequest.click_StartDate();
		newVacationRequest.settingDateByGivenParameter(date);
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	public void setEndDate(String date) throws ParseException {
		newVacationRequest.click_EndDate();
		newVacationRequest.settingDateByGivenParameter(date);
		
	}
	
		
	@Step
	public void selectConcediuSpecialReason(String specV){
		//newVacationRequest.click_special_vacation();
		newVacationRequest.selectSpecialReason(specV);
		newVacationRequest.clickForAddComment();
	}
	
	@Step
	public void addTextAreaComment(String comment){
		newVacationRequest.addTextAreaComment(comment);
	}
	
	@Step
	public void clickSaveButton(){
		newVacationRequest.clickSaveButton();
	}

}
