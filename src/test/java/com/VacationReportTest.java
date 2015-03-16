package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.VacationReportCheckNamesSteps;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/namesTestData.csv")
public class VacationReportTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String lastname_input, firstname_input;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;

	@Steps
	public LogInSteps logIn;
	
	//@Steps
	//public MyRequestsSteps reqSteps;

	@Steps
	public VacationReportCheckNamesSteps vacReqest;
	

	//@Test
	public void filter_and_check_filtered_data() {

		logIn.isTheLoginPage();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();
		logIn.clickVacation();
		vacReqest.click_on_VacationReport_button();
		vacReqest.insert_LastName(lastname_input);
		vacReqest.insert_FirstName(firstname_input);
		vacReqest.click_SearchButton();
		//vacReqest.error_message_displayed();
		vacReqest.check_lastname_input(lastname_input);
		

	}
	@Test
	public void no_users_error_message_displayed(){
		
		logIn.isTheLoginPage();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();
		logIn.clickVacation();
		vacReqest.click_on_VacationReport_button();
		vacReqest.insert_LastName(lastname_input);
		vacReqest.insert_FirstName(firstname_input);
		vacReqest.click_SearchButton();
		vacReqest.error_message_displayed();
	}
	

}
