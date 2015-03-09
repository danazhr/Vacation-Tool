package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.InboxSteps;
import com.steps.LogInSteps;
@RunWith(ThucydidesRunner.class)
public class InboxTest {
	
	 @Managed(uniqueSession = true)
	    public WebDriver webdriver;
	 
	 @ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	    public Pages pages;
	 
	 @Steps
	 public InboxSteps inboxSteps;
	 
	 @Steps
	 public LogInSteps logInSteps;
	 
	 @Test
	 public void verify_that_inbox_requests_number_displayed_is_the_same_as_in_the_table(){
		 logInSteps.is_the_login_page();
		 logInSteps.entersUsername("dana.zaharia");
		 logInSteps.entersPassword("danna");
		 logInSteps.clickLogIn();
		 logInSteps.clickVacation();
		 inboxSteps.go_to_inbox();
		 Assert.assertEquals("expected requests number is different!!!", inboxSteps.get_inbox_requests_number(), inboxSteps.get_table_requests_number());
	 }
	 

}
