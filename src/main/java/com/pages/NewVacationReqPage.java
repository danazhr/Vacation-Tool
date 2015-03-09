package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVacationReqPage extends PageObject {
	@FindBy(css="a[href$='new-request']")
	private WebElementFacade new_vacation_button; 
	
	@FindBy(css="#selectedDaysContainer #businessDaysOutput")
	private WebElementFacade businessDaysOutput;
	
	public void go_to_new_request(){
		new_vacation_button.click();
	}
	
	public int get_businessDaysOutput(){
		System.out.println(businessDaysOutput.getText());
		return Integer.parseInt(businessDaysOutput.getText());
		
	}
	

}
