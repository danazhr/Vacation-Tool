package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyReqPage;

public class MyRequestsSteps extends ScenarioSteps {

	MyReqPage reqPage;

	@Step
	public void set_vacation_type(String checks) {
		reqPage.setVacationType(checks);
	}

	@Step
	public void set_daysnumber_type(String checks) {
		reqPage.setDaysNumberTyp(checks);
	}

	@Step
	public void set_vacationstatus_type(String checks) {
		reqPage.setVacationStatusType(checks);
	}

	@Step
	public void click_apply_filter_button() {
		reqPage.clickApplyFilterButton();
	}

	@Step
	public void check_recordsnotfound_message(String compValue) {

		Assert.assertTrue(
				"Mesajul nu este corect",
				reqPage.norecordsfoundMessage.getText().toLowerCase()
						.equals(compValue.toLowerCase()));
	}

	@Step
	public void check_table() {
		Assert.assertFalse("Tabelul nu este afisat",
				reqPage.vacationsTable.isVisible());
	}

	@Step
	public void click_only_future_vacation_button() {
		reqPage.clickOnlyFutureVacationButton();
	}

	@Step
	public void click_apply_filter_button1() {
		reqPage.clickApplyFilterButton();
	}
}
