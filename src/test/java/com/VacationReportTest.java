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
	

	@Test
	public void searchLastNames() {
		logIn.loginAs("dana.zaharia", "danna");
		/*logIn.isTheLoginPage();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();*/
		logIn.clickVacation();
		vacReqest.clickVacationReportButton();
		vacReqest.insertLastName(lastname_input);
		vacReqest.insertFirstName(firstname_input);
		vacReqest.clickTheSearchButton();
		vacReqest.verifyLastNameInput(lastname_input);		
	}
	
	@Test
	public void searchFirstName(){
		logIn.loginAs("dana.zaharia", "danna");
		/*logIn.isTheLoginPage();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();*/
		logIn.clickVacation();
		vacReqest.clickVacationReportButton();
		vacReqest.insertLastName(lastname_input);
		vacReqest.insertFirstName(firstname_input);
		vacReqest.clickTheSearchButton();
		vacReqest.verifyFirstNameInput(firstname_input);
		
	}
	

}
