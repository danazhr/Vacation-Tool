package com;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.NewVacationReqSteps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/TypeOfHolidayDriven.csv")

public class DDnewVacationReqTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public NewVacationReqSteps newVacationReqSteps;

	@Steps
	public LogInSteps logIn;

	@Test
	public void adding_comment_to_a_special_req_that_was_selected()
			throws ParseException {
		logIn.is_the_login_page();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();
		logIn.clickVacation();
		newVacationReqSteps.click_newVacationReq();
		newVacationReqSteps.setStartDate("6/4/2015");
		newVacationReqSteps.setEndDate("15/4/2015");
		
	}

}
