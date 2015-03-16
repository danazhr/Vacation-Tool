package com.pages;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

public class VacationsReportPage extends MyReqPage {

	@FindBy(css = ".portlet-msg-info")
	public WebElementFacade nousersfoundMessage;

	@FindBy(css = "a[href$='vacation-report']")
	private WebElementFacade vacationreportButton;

	public void go_to_VacationReport() {
		vacationreportButton.click();
	}

	@FindBy(css = "input[name$='reportFirstName']")
	public WebElementFacade inputtextFirstName;

	public void input_FirstName(String firstname_input) {
		inputtextFirstName.click();
		inputtextFirstName.type(firstname_input);
	}

	@FindBy(css = "input[name$='reportLastName']")
	public WebElementFacade inputtextLastName;

	public void input_LastName(String lastname_input) {
		inputtextLastName.click();
		inputtextLastName.type(lastname_input);
	}

	@FindBy(css = "input[value='Search']")
	private WebElementFacade searchButton;

	public void click_Search() {
		searchButton.click();

	}

	@FindBy(css = ".taglib-search-iterator")
	public List<WebElementFacade> tablenameList;

	public void check_Last_Name(String lastname_input) {

		if (tablenameList.size() > 0) {
			for (WebElement lastname_element : tablenameList) {

				// Daca stringul este prezent , sa fie afisate elementele care
				// contin stringul respectiv

				if ((lastname_element.getText().contentEquals(lastname_input))) {
					System.out
							.print("!!!!!!!!!!!!!!!!!  I found my request  !!! "
									+ lastname_element.getText());

					/*
					 * } else { Assert.assertTrue("Mesajul nu este afisat",
					 * norecordsfoundMessage .isDisplayed());
					 * 
					 * }
					 */
				}
			}
		}
	}
}
