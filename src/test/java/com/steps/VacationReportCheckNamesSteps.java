package com.steps;

import org.junit.Assert;

import com.pages.VacationsReportPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.WebElementState;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationReportCheckNamesSteps extends ScenarioSteps {

	VacationsReportPage vacRep;

	@Step
	public void click_on_VacationReport_button() {
		vacRep.go_to_VacationReport();
	}

	@Step
	public void insert_LastName(String lastname_input) {
		vacRep.input_LastName(lastname_input);
	}

	@Step
	public void insert_FirstName(String firstname_input) {
		vacRep.input_FirstName(firstname_input);
	}

	@Step
	public void click_SearchButton() {
		vacRep.click_Search();
	}

	@Step
	public void check_lastname_input(String lastname_input) {
		vacRep.check_Last_Name(lastname_input);

	}
	
		
	@Step
	public void check_recordsnotfound_message() {

		Assert.assertTrue(
				"Mesajul nu este corect",
				vacRep.nousersfoundMessage.getText().toLowerCase()
						.equals("No user we're found".toLowerCase()));
	}

	@Step
	public void check_table_of_names_displayed() {
		Assert.assertFalse("Tabelul este afisat", vacRep.vacationreportTable.isDisplayed());
		
	
	}

	@Step
	public void check_firstname_input(String firstname_input) {
		vacRep.check_First_Name(firstname_input);

	}

	

}

