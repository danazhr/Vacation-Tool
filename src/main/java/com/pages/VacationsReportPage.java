package com.pages;

import java.util.List;

import net.thucydides.core.annotations.findby.By;
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

	@FindBy(css = ".lfr-search-container")
	public WebElementFacade vacationreportTable;

	public void check_Last_Name(String lastname_input) {

		List<WebElement> last_nameList = getDriver().findElements(
				By.cssSelector("td[class*='col-1'].col-last-name"));

		if (last_nameList != null) {
			for (WebElement vacationreportTable : last_nameList) {

				// Daca stringul este prezent , sa fie afisate elementele care
				// contin stringul respectiv

				/*if ((vacationreportTable.getText().contains(lastname_input))) {
					System.out
							.println("!!!!!!!!!!!!!!!!!  Last name string found  !!! ");

				}

				else {
					System.out
							.println("!!!!!!!!!!!!!!!!!  Last name string not found  !!! ");

				}*/
				
				Assert.assertTrue("Elementul nu este continut", vacationreportTable.toString().contains(lastname_input));

			}
		}

		else {
			Assert.assertFalse("Tabelul este afisat",
					nousersfoundMessage.isVisible());
		}

	}

	public void check_First_Name(String firstname_input) {

		List<WebElement> first_nameList = getDriver().findElements(
				By.cssSelector("td[class*='col-2'].col-first-name"));
		if (first_nameList != null) {
			for (WebElement vacationreportTable : first_nameList) {

				// Daca stringul este prezent , sa fie afisate elementele care
				// contin stringul respectiv

				/*if ((vacationreportTable.getText().contains(firstname_input))) {
					System.out
							.println("!!!!!!!!!!!!!!!!!  First name string found  !!! ");

				}

				else {
					System.out
							.println("!!!!!!!!!!!!!!!!!  Last name string not found  !!! ");

				}
			*/
			
				Assert.assertTrue("Elementul nu este continut", vacationreportTable.toString().contains(firstname_input));
			}
				
		}

		else {
			Assert.assertFalse("Tabelul este afisat",
					nousersfoundMessage.isVisible());
		}

	}
}