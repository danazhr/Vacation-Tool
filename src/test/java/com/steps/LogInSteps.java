package com.steps;

import com.pages.LogInPage;
import com.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LogInSteps extends ScenarioSteps {
	
	
	LogInPage loginPage;
	HomePage mainPage;
		
	@Step
	public void isTheLoginPage(){
		loginPage.open();
		loginPage.getDriver().manage().window().maximize();
		loginPage.goToLogin();
	}
	
	
	
	@Step
	public void entersUsername(String user){
		loginPage.enterUsername(user);
	}

	@Step
	public void entersPassword(String pass){
		loginPage.enterPassword(pass);
	}
	
	@Step
	public void clickLogIn(){
		loginPage.login();
	}
	
	@Step
	public void clickVacation(){
		mainPage.goToVacation();
		
	}
	
	
	
	

}
