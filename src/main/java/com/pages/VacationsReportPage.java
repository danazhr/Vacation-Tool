package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.support.FindAll;

public class VacationsReportPage {
	
	@FindBy(css= "a[href$='vacation-report']")
	private WebElementFacade vacationreportButton;
	
	public void go_to_VacationReport(){
		vacationreportButton.click();
	}

	@FindBy(css= "input[name$='reportFirstName']")
	private WebElementFacade inputtextFirstName;
	
	public void input_FirstName(String firstname_input){
			inputtextFirstName.type(firstname_input);
	}
	
	@FindBy(css= "a[href$='reportLastName']")
	private WebElementFacade inputtextLastName;
	
	public void input_LastName(String lastname_input){
		inputtextLastName.type(lastname_input);
	}
	
	@FindBy(css= "input[value='Search']")
	private WebElementFacade searchButton;
	
	public void click_Search(){
		searchButton.click();;
	}
	
	
	
	
}
