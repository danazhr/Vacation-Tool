package com.steps;

import java.text.ParseException;

import com.pages.MyFreeDaysNewVacReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysNewVacReqSteps extends ScenarioSteps {

	MyFreeDaysNewVacReqPage myFreeDaysNewVacReq;

	@Step
	public void click_my_request() {
		myFreeDaysNewVacReq.go_to_my_free_days();
	}

	@Step
	public void get_Index_Number() {
		myFreeDaysNewVacReq.getInboxNumber();
	}

	@Step
	public void go_to_new_request() {
		myFreeDaysNewVacReq.go_to_new_request();
	}

	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void click_start_date(String date) throws ParseException {
		myFreeDaysNewVacReq.click_start_date();
		myFreeDaysNewVacReq.settingDateByGivenParameter(date);
	}

	
	/**
	 * @param date format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void click_end_date(String date) throws ParseException {
		myFreeDaysNewVacReq.click_end_date();
		myFreeDaysNewVacReq.settingDateByGivenParameter(date);
	}

	@Step
	public void click_Save_Button() {
		myFreeDaysNewVacReq.click_save_button();
	}

}
