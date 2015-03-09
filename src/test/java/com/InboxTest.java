package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

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
	 public void open_inbox_page(){
		 logInSteps.is_the_login_page();
		 logInSteps.entersUsername("dana.zaharia");
		 logInSteps.entersPassword("danna");
		 logInSteps.clickLogIn();
		 logInSteps.clickVacation();
		 inboxSteps.click_inbox();
		 
	 }
	 

}
