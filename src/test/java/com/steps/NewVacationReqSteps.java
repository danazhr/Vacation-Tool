package com.steps;

import java.text.ParseException;

import org.junit.Assert;

import com.pages.NewVacationReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationReqSteps extends ScenarioSteps {

	NewVacationReqPage newVacationRequest;
	
	
	@Step
	public void clickNewVacationReq() {
		newVacationRequest.goToNewRequest();
	}

	@Step
	public int getBusinessDaysOutput() {
		//return newVacationRequest.get_businessDaysOutput();
		return 1;
	}

	
		
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setStartDate(String date) throws ParseException{
		newVacationRequest.clickStartDate();
		newVacationRequest.settingDateByGivenParameter(date);
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	public void setEndDate(String date) throws ParseException {
		newVacationRequest.clickEndDate();
		newVacationRequest.settingDateByGivenParameter(date);
		
	}
	
		
	@Step
	public void getFirstErrorMessage() {
		newVacationRequest.getFirstErrorMessage();
	}
	
	@Step
	public void getSecondErrorMessage() {
		newVacationRequest.getSecondErrorMessage();
	}
	
		
	@Step
	public void clickSaveButton(){
		newVacationRequest.clickSaveButton();
	}

}
