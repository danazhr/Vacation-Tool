package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyReqPage;

public class MyRequestsSteps extends ScenarioSteps {

	MyReqPage reqPage;

	@Step
	public void set_vacation_type(String checks) {
		reqPage.set_vacation_type(checks);
	}

	@Step
	public void set_daysnumber_type(String checks) {
		reqPage.set_daysnumber_type(checks);
	}

	@Step
	public void set_vacationstatus_type(String checks) {
		reqPage.set_vacationstatus_type(checks);
	}

	@Step
	public void click_apply_filter_button() {
		reqPage.click_apply_filter_button();
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
		reqPage.click_only_future_vacation_button();
	}

	@Step
	public void click_apply_filter_button1() {
		reqPage.click_apply_filter_button();
	}
}
