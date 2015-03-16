package com.steps;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationReqPage;

public class DDNewReqSteps extends ScenarioSteps {

	NewVacationReqPage ddReqPage;
	
	@Step
	public void clickNewVacationReq() {
		ddReqPage.goToNewRequest();
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setStartDate(String date) throws ParseException{
		ddReqPage.clickStartDate();
		ddReqPage.settingDateByGivenParameter(date);
	}
	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setEndDate(String date) throws ParseException {
		ddReqPage.clickEndDate();
		ddReqPage.settingDateByGivenParameter(date);
	}
	
	@Step
	public void setVacationType (String vacationType) {
		ddReqPage.clickVacantionCheckbox(vacationType);
	}
	
	@Step
	public void selectSpecialReason(String specV) {
		ddReqPage.selectSpecialReason(specV);
	}
	
	
	@Step
	public void addTextAreaComment(String comment) {
	ddReqPage.addTextAreaComment(comment);
    }

	
	@Step
	public void clickSaveButton() {
		ddReqPage.clickSaveButton();
	}
	

}

