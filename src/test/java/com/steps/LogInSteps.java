package com.steps;

import com.pages.LogInPage;
import com.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LogInSteps extends ScenarioSteps {
	
	
	LogInPage loginPage;
	HomePage mainPage;
	
	@Step
	public void is_the_login_page(){
		loginPage.open();
		loginPage.go_to_login();
	}
	
	@Step
	public void entersUsername(String user){
		loginPage.enter_username(user);
	}

	@Step
	public void entersPassword(String pass){
		loginPage.enter_password(pass);
	}
	
	@Step
	public void clickLogIn(){
		loginPage.login();
	}
	
	@Step
	public void clickVacation(){
		mainPage.go_to_vacation();
		
	}
	
	

}
