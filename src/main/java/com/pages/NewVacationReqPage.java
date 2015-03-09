package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVacationReqPage extends PageObject {
	@FindBy(css="a[href$='new-request']")
	private WebElementFacade new_vacation_button; 
	
	public void go_to_new_request(){
		new_vacation_button.click();
	}

}
