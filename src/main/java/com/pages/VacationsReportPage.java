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
	public WebElementFacade noUsersFoundMessage;

	@FindBy(css = "a[href$='vacation-report']")
	private WebElementFacade vacationReportButton;

	@FindBy(css = "input[name$='reportFirstName']")
	public WebElementFacade inputTextFirstName;

	@FindBy(css = "input[name$='reportLastName']")
	public WebElementFacade inputTextLastName;

	@FindBy(css = "input[value='Search']")
	private WebElementFacade searchButton;

	@FindBy(css = ".lfr-search-container")
	public WebElementFacade vacationreportTable;

	public void clickVacationReport() {
		vacationReportButton.click();
	}

	public void inputFirstName(String firstname_input) {
		inputTextFirstName.click();
		inputTextFirstName.type(firstname_input);
	}

	public void inputLastName(String lastname_input) {
		inputTextLastName.click();
		inputTextLastName.type(lastname_input);
	}

	public void clickSearchButton() {
		searchButton.click();

	}

	public void verifyLastName(String lastname_input) {

		List<WebElement> last_nameList = getDriver().findElements(
				By.cssSelector("td[class*='col-1'].col-last-name"));

		if (last_nameList != null) {
			for (WebElement vacationreportTable : last_nameList) {

				Assert.assertTrue("Elementul nu este continut",
						vacationreportTable.toString().contains(lastname_input));

			}
		}

		else {
			Assert.assertFalse("Tabelul este afisat",
					noUsersFoundMessage.isVisible());
		}

	}

	public void verifyFirstName(String firstname_input) {

		List<WebElement> first_nameList = getDriver().findElements(
				By.cssSelector("td[class*='col-2'].col-first-name"));
		if (first_nameList != null) {
			for (WebElement vacationreportTable : first_nameList) {

				Assert.assertTrue("Elementul nu este continut",
						vacationreportTable.toString()
								.contains(firstname_input));
			}

		}

		else {
			Assert.assertFalse("Tabelul este afisat",
					noUsersFoundMessage.isVisible());
		}

	}
}