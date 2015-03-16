package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.EditWithdrawRequestSteps;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/SpecialVacation.csv")
public class EditWithdrawRequestTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	String StartDate, EndDate, VacationType, Reason, Comment, VacationType2;

	@Steps
	public EditWithdrawRequestSteps editWithdrawRequestTest;

	@Steps
	public LogInSteps logIn;

	@Steps
	public MyRequestsSteps editWithdrawTest;

	@Test
	public void EditWithdrawRequestTest() throws ParseException {
		logIn.isTheLoginPage();
		logIn.entersUsername("virginiaanca.oprean");
		logIn.entersPassword("1234");
		logIn.clickLogIn();
		logIn.clickVacation();
		editWithdrawRequestTest.clickNewVacationReq();
		editWithdrawRequestTest.setStartDate(StartDate);
		editWithdrawRequestTest.setEndDate(EndDate);
		editWithdrawRequestTest.setVacationType(VacationType);
		editWithdrawRequestTest.selectSpecialReason(Reason);
		editWithdrawRequestTest.addOptionalComment();
		editWithdrawRequestTest.addTextAreaComment(Comment);
		editWithdrawRequestTest.clickSaveButton();
		editWithdrawRequestTest.clickEditVacationReq();
		editWithdrawRequestTest.switchToEditFrame();
		editWithdrawRequestTest.setVacationType("Holiday");
		editWithdrawRequestTest.clickSaveButton();
		editWithdrawRequestTest.clickWithdrawButton();
		editWithdrawRequestTest.getSuccessMessage();

	}

}
