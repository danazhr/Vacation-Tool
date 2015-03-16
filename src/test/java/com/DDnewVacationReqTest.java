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
@UseTestDataFrom("Resources/TypeOfHolidayDriven.csv")

public class DDnewVacationReqTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	String StartDate,EndDate,VacationType,Reason,Comment;

	@Steps
	public DDNewReqSteps ddNewReqSteps;

	@Steps
	public LogInSteps logIn;

	@Test
	public void addingcCommentToSelectedSpecialReq()
			throws ParseException {
		logIn.isTheLoginPage();
		logIn.entersUsername("virginiaanca.oprean");	//dana.zaharia
		logIn.entersPassword("1234");	//danna
		logIn.clickLogIn();
		logIn.clickVacation();
		ddNewReqSteps.clickNewVacationReq();
		ddNewReqSteps.setStartDate(StartDate);
		ddNewReqSteps.setEndDate(EndDate);
		ddNewReqSteps.setVacationType(VacationType);
		ddNewReqSteps.selectSpecialReason("reason");
		ddNewReqSteps.addOptinalComment();
		ddNewReqSteps.addTextAreaComment("comment");
		ddNewReqSteps.clickSaveButton();
		
	}

}
