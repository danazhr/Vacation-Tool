package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.ViewVacationSteps;

@RunWith(ThucydidesRunner.class)

public class ViewVacationTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	@Steps
	public LogInSteps logInSteps;
	
	@Steps
	public ViewVacationSteps viewVacationSteps;
	
	@Test
	public void verifyThatFiltersAppliedOnViewVacationsAndTableCanBeSorted() throws Exception{
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		viewVacationSteps.goToViewVacations();
		viewVacationSteps.setDaysNumberFilter("1 - 5");
		viewVacationSteps.setLastNameFilter("Marian");
		viewVacationSteps.clickApply();
		viewVacationSteps.checkIfFilterLastnameAppliedForTable("Marian");
		viewVacationSteps.clickDaysNumberHeaderToSort();
		viewVacationSteps.checkSortDays();
		
	}
	
}
