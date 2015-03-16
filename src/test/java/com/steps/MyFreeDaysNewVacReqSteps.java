package com.steps;

import java.text.ParseException;

import com.pages.MyFreeDaysNewVacReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysNewVacReqSteps extends ScenarioSteps {

	MyFreeDaysNewVacReqPage myFreeDaysNewVacReq;

	@Step
	public void clickMyRequest() {
		myFreeDaysNewVacReq.goToMyFreeDays();
	}

	@Step
	public void getIndexNumber() {
		myFreeDaysNewVacReq.getInboxNumber();
	}

	@Step
	public void goToNewRequest() {
		myFreeDaysNewVacReq.goToNewRequest();
	}

	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void clickStartDate(String date) throws ParseException {
		myFreeDaysNewVacReq.clickStartDate();
		myFreeDaysNewVacReq.settingDateByGivenParameter(date);
	}

	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void clickEndDate(String date) throws ParseException {
		myFreeDaysNewVacReq.clickEndDate();
		myFreeDaysNewVacReq.settingDateByGivenParameter(date);
	}

	@Step
	public void clickSaveButton() {
		myFreeDaysNewVacReq.clickSaveButton();
	}

}
