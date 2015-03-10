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
		return newVacationRequest.get_businessDaysOutput();
	}
	
	@Step
	public void setStartDate(int month, int day, int year) throws ParseException{
		newVacationRequest.click_StartDate();
		newVacationRequest.settingDateByGivenParameter(month, day, year);
	}
	
	@Step
	public void setEndDate(int month, int day, int year) throws ParseException{
		newVacationRequest.click_EndDate();
		newVacationRequest.settingDateByGivenParameter(month, day, year);
	}
	
	@Step
	public void selectConcediuSpecialReason(String specV){
		newVacationRequest.click_concediuSpecial();
		newVacationRequest.selectSpecialReason(specV);
		newVacationRequest.clickForAddComment();
	}
	
	@Step
	public void addTextAreaComment(String comment){
		newVacationRequest.addTextAreaComment(comment);
	}
	

}
