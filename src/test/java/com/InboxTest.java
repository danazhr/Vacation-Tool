package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Utils.ImapHelper;

import com.steps.InboxSteps;
import com.steps.LogInSteps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

@RunWith(ThucydidesRunner.class)
//@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom("Resources/DifferentStartAndEndDatesReq.csv")
public class InboxTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public InboxSteps inboxSteps;

	@Steps
	public LogInSteps logInSteps;

	String startDate, endDate, name;

	@Steps
	public ImapHelper imapSteps;

	// @Test
	public void verifyThatInboxRequestsNumberDisplayedIsTheSameAsInTheTable() {
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		inboxSteps.goToInbox();
		Assert.assertEquals("expected requests number is different!!!",
				inboxSteps.getInboxRequestsNumber(),
				inboxSteps.getTableRequestsNumber());
	}

	// @Test
	public void verifyThatApproveButtonWorksForSelectedRequestAndDeleteItFromTable()
			throws ParseException {
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		inboxSteps.goToInbox();
		inboxSteps.selectRequest("Anca Oprean", "14/05/2015");
		inboxSteps.clickApproveButton();
		inboxSteps.checkIfSelectedRequestWasApproved("Anca Oprean","14/05/2015");

	}

	//@Test
	public void verifyThatApproveButtonWorksForSelectedRequestAndSendsEmail()
			throws ParseException, MessagingException, IOException {
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		inboxSteps.goToInbox();

		String employee_name = "Anca Oprean";
		String start = "12/03/2015";

		inboxSteps.selectRequest(employee_name, start);
		inboxSteps.clickApproveButton();
		inboxSteps.checkIfSelectedRequestWasApproved(employee_name, start);

		String subject = employee_name + " Vacation Request Approved";
		String body = "The Vacation Request submitted by <strong>" + employee_name + "</strong>";
		
		
		imapSteps.checkLastEmailSubjectAndBody(subject, body);

	}

	//@Test
	public void verifyThatTheWorkdaysNumberFromTableIsCorrect()
			throws ParseException {
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		inboxSteps.goToInbox();
		//inboxSteps.check_if_number_of_workdays_is_correct(startDate, endDate,name);//using data driven file
		inboxSteps.checkIfNumberOfWorkdaysIsCorrect("02/06/2015","04/06/2015", "Anca Oprean");
		
	}

	@Test
	public void verifyThatByClickingElementsFromTheSameRowOfTableItOpensTheSamePageInfo() {
		logInSteps.isTheLoginPage();
		logInSteps.entersUsername("dana.zaharia");
		logInSteps.entersPassword("danna");
		logInSteps.clickLogIn();
		logInSteps.clickVacation();
		inboxSteps.goToInbox();
		inboxSteps.clickSpecificLinkToVerifyInfo("Anca Oprean", "02/06/2015");
		
	
}
}
