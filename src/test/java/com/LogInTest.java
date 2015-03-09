package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
@RunWith(ThucydidesRunner.class)
public class LogInTest {
	
	 @Managed(uniqueSession = true)
	    public WebDriver webdriver;
	 
	 @ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	    public Pages pages;
	 
	 @Steps
	 public LogInSteps logIn;
	 
	 @Test
	 public void login_with_user_and_password(){
		 logIn.is_the_login_page();
		 logIn.entersUsername("virginiaanca.oprean");
		 logIn.entersPassword("1234");
		 logIn.clickLogIn();
	 }
	 

}
