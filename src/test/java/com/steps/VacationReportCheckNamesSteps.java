package com.steps;

import org.junit.Assert;

import com.pages.VacationsReportPage;

import net.thucydides.core.annotations.Step;
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
	public void error_message_displayed() {
		Assert.assertTrue("Mesajul nu este afisat",vacRep.nousersfoundMessage.getText().toLowerCase().contains("No user we're found".toLowerCase())); 
		}
	//Assert.assertTrue("Mesajul nu este afisat",norecordsfoundMessage.isDisplayed());  
	@Step
	public void check_table() {
		Assert.assertTrue("Tabelul nu este afisat",vacRep.tablenameList.isEmpty());
	}

}

