package com.steps;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationReqPage;

public class DDNewReqSteps extends ScenarioSteps {

	NewVacationReqPage ddReqPage;
	
	@Step
	public void click_newVacationReq() {
		ddReqPage.go_to_new_request();
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setStartDate(String date) throws ParseException{
		ddReqPage.click_StartDate();
		ddReqPage.settingDateByGivenParameter(date);
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setEndDate(String date) throws ParseException {
		ddReqPage.click_EndDate();
		ddReqPage.settingDateByGivenParameter(date);
	}
	
	@Step
	public void setVacationType (String vacationType) {
		ddReqPage.clickVacantionCheckbox(vacationType);
	}
	
	@Step
	public void clickSaveButton() {
		ddReqPage.clickSaveButton();
	}
	

}


