package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.MyFreeDaysNewVacReqSteps;

@RunWith(ThucydidesRunner.class)
	public class MyFreeDaysNewVacReqTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	@Steps
	public MyFreeDaysNewVacReqSteps myFreeDaysNewReqTest;
	
	@Steps
	public LogInSteps logIn;
	
	@Test
	public void my_free_days_new_request() throws ParseException {
		logIn.is_the_login_page();
		logIn.entersUsername("virginiaanca.oprean");
		logIn.entersPassword("1234");
		logIn.clickLogIn();
		logIn.clickVacation();
		myFreeDaysNewReqTest.click_my_request();
		myFreeDaysNewReqTest.get_Index_Number();
		myFreeDaysNewReqTest.go_to_new_request();
		myFreeDaysNewReqTest.click_start_date("10/08/2015");
		myFreeDaysNewReqTest.click_end_date("10/08/2015");
		myFreeDaysNewReqTest.click_Save_Button();
	}
	

}
