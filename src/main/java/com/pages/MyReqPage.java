package com.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
public class MyReqPage extends PageObject {
	
	@FindBy(css="a[href$='my-requests']") 
	private WebElementFacade myRequestButton;
	
	public void go_to_my_request(){
		myRequestButton.click();
	}
	
	@FindBy(css = "input[id$='vacationTypeALLCheckbox']") 
	private WebElementFacade allvacationCheckbox;
	
	@FindBy(css = "input[id$='HOLIDAYCheckbox']") 
	private WebElementFacade holidayCechbox;
	
	@FindBy(css = "input[id$='PAYMENTCheckbox']") 
	private WebElementFacade withoutpaymentCechbox;
	
	@FindBy(css = "input[id$='VACATIONCheckbox']") 
	private WebElementFacade specialvacationCechbox;
	
	@FindBy(css = "input[id$='LEAVECheckbox']") 
	private WebElementFacade sickleaveCechbox;
	
	@FindBy(css = "input[id$='daysNumberALLCheckbox']") 
	private WebElementFacade alldaysnumberCheckbox;
	
}
