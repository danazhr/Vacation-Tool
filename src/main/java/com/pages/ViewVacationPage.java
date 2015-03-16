package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class ViewVacationPage extends PageObject {

	@FindBy(css = "li[class*='active-menu'] a[href*='menuItem=view-vacations']")
	public WebElementFacade viewVacations;

	@FindBy(css = "div[class='aui-column column-three column-center '] .aui-field-input")
	private List<WebElementFacade> daysNumberCheckBoxes;

	@FindBy(css = "div[class='aui-column column-three column-center '] .aui-choice-label")
	private List<WebElementFacade> daysNumber;

	@FindBy(css = "input[value='Apply']")
	public WebElementFacade applyButton;

	@FindBy(css = "input[name$='_viewVacationsLastName']")
	public WebElementFacade lastNameFilter;

	@FindBy(css = "input[name$='_viewVacationsFirstName']")
	public WebElementFacade firstNameFilter;

	@FindBy(css = "table[class='taglib-search-iterator']")
	public WebElementFacade table;

	@FindBy(css = "td[class*='employee.name']")
	public List<WebElement> names;

	@FindBy(css = "th[class*='day.number'] a[href*='orderByType=']")
	public WebElementFacade daysNoHeader;

	@FindBy(css = "td[class*='day.number'] a")
	public List<WebElement> tableDays;

	public void clickViewVacations() {
		viewVacations.waitUntilVisible();
		viewVacations.click();
	}

	public void setDaysNumberFilter(String interval) {
		for (WebElement daysno : daysNumber) {
			if (daysno.getText().toLowerCase().equals(interval.toLowerCase())) {
				daysno.click();
			}
		}
		System.out.println("Interval checked: " + interval);
	}

	public void setLastNameFilter(String lastname) {
		lastNameFilter.type(lastname);

	}

	public void checkIfFilterLastnameAppliedForTable(String lastname) {

		for (WebElement name : names) {
			if (name.getText().toLowerCase().contains(lastname.toLowerCase())) {
				System.out
						.println("Table contains only names that correspond with the filter!");

			} else {
				System.out.println("Table contains also other names");
			}
		}

	}

	public void clickDaysNumberHeader() {
		daysNoHeader.click();
	}

	public void checkSortDays() throws Exception {

		if (daysNoHeader.getAttribute("href").contains("desc")) {

			for (int i = 0; i < tableDays.size() - 1; i++) {
				int prec = Integer.parseInt(tableDays.get(i).getText());
				int next = Integer.parseInt(tableDays.get(i + 1).getText());
				Assert.assertTrue("Days not sorted!", prec <= next);
			}
		} else {
			if (daysNoHeader.getAttribute("href").contains("asc")) {

				for (int i = 0; i < tableDays.size() - 1; i++) {
					int prec = Integer.parseInt(tableDays.get(i).getText());
					int next = Integer.parseInt(tableDays.get(i + 1).getText());
					Assert.assertTrue("Days not sorted!", prec >= next);
				}
			}
			else throw new Exception("Could not find asc or desc!");
		}
	}

	public void clickApply() {
		applyButton.click();

	}

}
