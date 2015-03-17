package com.steps;

import org.junit.Assert;

import com.pages.VacationsReportPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.WebElementState;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationReportCheckNamesSteps extends ScenarioSteps {

	VacationsReportPage vacRep;

	@Step
	public void clickVacationReportButton() {
		vacRep.clickVacationReport();
	}

	@Step
	public void insertLastName(String lastname_input) {
		vacRep.inputLastName(lastname_input);
	}

	@Step
	public void insertFirstName(String firstname_input) {
		vacRep.inputFirstName(firstname_input);
	}

	@Step
	public void clickTheSearchButton() {
		vacRep.clickSearchButton();
	}

	@Step
	public void verifyLastNameInput(String lastname_input) {
		vacRep.verifyLastName(lastname_input);

	}
	
		
	@Step
	public void verifyUserNotFoundMessage() {

		Assert.assertTrue(
				"Mesajul nu este corect",
				vacRep.noUsersFoundMessage.getText().toLowerCase()
						.equals("No user we're found".toLowerCase()));
	}

	@Step
	public void verifyTableIsDisplayed() {
		Assert.assertFalse("Tabelul este afisat", vacRep.vacationreportTable.isDisplayed());
		
	
	}

	@Step
	public void verifyFirstNameInput(String firstname_input) {
		vacRep.verifyFirstName(firstname_input);

	}

	

}

