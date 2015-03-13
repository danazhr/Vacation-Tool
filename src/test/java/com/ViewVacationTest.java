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
	public void verify_that_filters_applies_on_view_vacations(){
		logInSteps.is_the_login_page();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		viewVacationSteps.go_to_viewVacations();
		viewVacationSteps.set_days_number_filter("1-5");
		viewVacationSteps.set_lastName_filter("Oprean");
		viewVacationSteps.click_apply();
		
	}
	
}
