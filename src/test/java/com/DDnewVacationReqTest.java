package com;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.DDNewReqSteps;
import com.steps.LogInSteps;
import com.steps.NewVacationReqSteps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/SendVacationReq_4MyReq.csv")

public class DDnewVacationReqTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	String StartDate,EndDate,VacationType,Comment;

	@Steps
	public DDNewReqSteps ddNewReqSteps;

	@Steps
	public LogInSteps logIn;

	@Test
	public void adding_comment_to_a_special_req_that_was_selected()
			throws ParseException {
		logIn.isTheLoginPage();
		logIn.entersUsername("dana.zaharia");	//virginiaanca.oprean
		logIn.entersPassword("danna");	//1234
		logIn.clickLogIn();
		logIn.clickVacation();
		ddNewReqSteps.click_newVacationReq();
		ddNewReqSteps.setStartDate(StartDate);
		ddNewReqSteps.setEndDate(EndDate);
		ddNewReqSteps.setVacationType(VacationType);
		ddNewReqSteps.clickSaveButton();
		
	}

}
