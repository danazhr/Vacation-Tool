package com.pages;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MyReqPage extends PageObject {

	@FindBy(css = "a[href$='my-requests']")
	private WebElementFacade myRequestButton;

	public void go_to_my_request() {
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

	@FindBy(css = ".filter-content .aui-column-content-first .aui-field-input")
	private List<WebElementFacade> vacationTypeList;

	public void set_vacation_type(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(vacationTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}

	@FindBy(css = " div[class$='column-center '] .aui-field-input")
	private List<WebElementFacade> daysnumberTypeList;

	public void set_daysnumber_type(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(daysnumberTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}

	@FindBy(css = "div[class$='aui-column column-three column-center aui-column-last'] div:nth-child(2) .aui-field-input ")
	private List<WebElementFacade> vacationstatusTypeList;

	public void set_vacationstatus_type(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(vacationstatusTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}
	
	@FindBy(css = ".aui-button-input")
	private WebElementFacade applyMyRequestButton;
	
	public void click_apply_filter_button() {
		applyMyRequestButton.click();
	}
	
	@FindBy(css = "span[class$='align-to-left'] .aui-field-input")
	private WebElementFacade onlyfutureVacationButton;
	
	public void click_only_future_vacation_button() {
		onlyfutureVacationButton.click();
	}
	
}
