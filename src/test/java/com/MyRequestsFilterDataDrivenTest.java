package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/filterTestData.csv")
public class MyRequestsFilterDataDrivenTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String Vacation_Type, Days_Number, Vacation_Status;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public LogInSteps logIn;
	@Steps
	public MyRequestsSteps reqSteps;

	@Test
	public void filter_and_check_filtered_data() {
		logIn.is_the_login_page();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();
		logIn.clickVacation();
		reqSteps.set_vacation_type(Vacation_Type);
		reqSteps.set_daysnumber_type(Days_Number);
		reqSteps.set_vacationstatus_type(Vacation_Status);
		reqSteps.click_apply_filter_button();
		reqSteps.click_only_future_vacation_button();
		reqSteps.click_apply_filter_button1();

	}

}
