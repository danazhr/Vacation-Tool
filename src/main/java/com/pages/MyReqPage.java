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

	@FindBy(css = ".portlet-msg-info")
	public WebElementFacade norecordsfoundMessage;

	@FindBy(css = ".lfr-search-container")
	public WebElementFacade vacationsTable;

	@FindBy(css = ".filter-content .aui-column-content-first .aui-field-input")
	private List<WebElementFacade> vacationTypeList;

	@FindBy(css = " div[class$='column-center '] .aui-field-input")
	private List<WebElementFacade> daysnumberTypeList;

	@FindBy(css = "div[class$='aui-column column-three column-center aui-column-last'] div:nth-child(2) .aui-field-input ")
	private List<WebElementFacade> vacationstatusTypeList;
	
	@FindBy(css = ".aui-button-input")
	private WebElementFacade applyMyRequestButton;
	
	@FindBy(css = "span[class$='align-to-left'] .aui-field-input")
	private WebElementFacade onlyfutureVacationButton;
	
	public void setVacationType(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(vacationTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}

	
	public void setDaysNumberTyp(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(daysnumberTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}

	

	public void setVacationStatusType(String checks) {
		for (int i = 1; i < checks.length(); i++) {
			if (checks.charAt(i) == '1') {
				element(vacationstatusTypeList.get(i)).click();
			}
		}
		System.out.println("checked");
	}

	public void clickApplyFilterButton() {
		applyMyRequestButton.click();
	}

	

	public void clickOnlyFutureVacationButton() {
		onlyfutureVacationButton.click();
	}

}
