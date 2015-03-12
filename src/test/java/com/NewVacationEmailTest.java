package com;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Utils.ImapHelper;

import com.steps.LogInSteps;
import com.steps.NewVacationReqSteps;


@RunWith(ThucydidesRunner.class)
public class NewVacationEmailTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	@Steps 
	public NewVacationReqSteps newVacationReqSteps;
	
	@Steps
	public LogInSteps logIn;
	
	@Steps
	public ImapHelper imapSteps;
	
	@Test
	public void adding_comment_to_a_special_req_that_was_selected() throws ParseException, MessagingException, IOException{
		logIn.is_the_login_page();
		logIn.entersUsername("virginiaanca.oprean");
		logIn.entersPassword("1234");
		logIn.clickLogIn();
		logIn.clickVacation();
		newVacationReqSteps.click_newVacationReq();
		
		String startDate = "13/03/2015";
		String endDate = "17/03/2015";
		
		newVacationReqSteps.setStartDate(startDate);
		newVacationReqSteps.setEndDate(endDate);
		newVacationReqSteps.clickSaveButton();
		
		String body ="Your holiday interval is: <strong>" + startDate + " - " + endDate + "</strong>.";
			
		imapSteps.checkLastEmailSubjectAndBody("You have submitted a new Vacation Request", body);
		
		}

}
