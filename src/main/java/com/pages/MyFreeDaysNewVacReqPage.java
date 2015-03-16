package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MyFreeDaysNewVacReqPage extends PageObject {
	@FindBy(css = "a[href$='my-free-days']")
	private WebElementFacade myFreeDaysButton;

	@FindBy(css = "tr.section-result td:nth-child(2)")
	private WebElementFacade availableDays;

	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade newVacationButton;

	@FindBy(css = "div[style*='block'] td.dp_caption")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[style*='block'] td.dp_next")
	private WebElementFacade nextButton;

	@FindBy(css = "div[style*='block'] td.dp_previous")
	private WebElementFacade previousButton;

	@FindBy(name = "startDate")
	private WebElementFacade startDateButton;

	@FindBy(name = "endDate")
	private WebElementFacade endDateButton;

	@FindBy(css = ".vacationTypeChoice label")
	private List<WebElement> selectVacationTypeList;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveVacReqButton;

	public void goToMyFreeDays() {
		myFreeDaysButton.click();
	}

	public int getInboxNumber() {
	String aString = availableDays.getText();
	String nr = aString.replaceAll("^0-9", "");
	int aInt = Integer.parseInt(nr);
	return aInt;
	}
	
	public void goToNewRequest() {
		newVacationButton.click();
	}

	public void clickStartDate() {
		startDateButton.click();
	}

	public void clickEndDate() {
		endDateButton.click();
	}
	
	public void settingDateByGivenParameter(String date) throws ParseException {

		String[] dateList = date.split("/");

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + dateList[1] + "/" + dateList[2]));

		Calendar cal = Calendar.getInstance();

		do {
			// get calendar title and create calendar value
			element(calendarTitle).waitUntilVisible();
			String MandY = calendarTitle.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy dd");
			cal.setTime(sdf.parse(MandY + " 1"));

			// go previous or next based on comparison
			if (cal.compareTo(calNew) == -1) {
				nextButton.click();
			}
			if (cal.compareTo(calNew) == 1) {
				previousButton.click();
			}

		} while (cal.compareTo(calNew) != 0);
		// until month and year are as expected

		// select day
		List<WebElement> days = getDriver().findElements(
				By.cssSelector("div[style*='block'] td"));
		for (WebElement currentDay : days) {
			if (currentDay.getText().contentEquals(String.valueOf(dateList[0])))
				currentDay.click();
		}
	}
	
	public void clickVacantionCheckbox(String vacationType) {
		List<WebElement> VacationTypes = getDriver().findElements(
				By.cssSelector("div[class='vacationTypeChoice'] label"));
		for (WebElement type : VacationTypes) {
			if (type.getText().toLowerCase().equals(vacationType.toLowerCase()))
				type.click();
		}
	}
	
	public void clickSaveButton() {
		saveVacReqButton.click();
	}
}

