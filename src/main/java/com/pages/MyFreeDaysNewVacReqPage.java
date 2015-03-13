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
	private WebElementFacade my_free_days_button;

	@FindBy(css = "tr.section-result td:nth-child(2)")
	private WebElementFacade available_days;

	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade new_vacation_button;

	@FindBy(css = "div[style*='block'] td.dp_caption")
	private WebElementFacade calendar_title;

	@FindBy(css = "div[style*='block'] td.dp_next")
	private WebElementFacade next_button;

	@FindBy(css = "div[style*='block'] td.dp_previous")
	private WebElementFacade previous_button;

	@FindBy(name = "startDate")
	private WebElementFacade start_date_button;

	@FindBy(name = "endDate")
	private WebElementFacade end_date_button;

	@FindBy(css = ".vacationTypeChoice label")
	private List<WebElement> select_vacation_type_list;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade save_vac_req_button;

	public void go_to_my_free_days() {
		my_free_days_button.click();
	}

	public int getInboxNumber() {
	String aString = available_days.getText();
	String nr = aString.replaceAll("^0-9", "");
	int aInt = Integer.parseInt(nr);
	return aInt;
	}
	
	public void go_to_new_request() {
		new_vacation_button.click();
	}

	public void click_start_date() {
		start_date_button.click();
	}

	public void click_end_date() {
		end_date_button.click();
	}
	
	public void settingDateByGivenParameter(String date) throws ParseException {

		String[] dateList = date.split("/");

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + dateList[1] + "/" + dateList[2]));

		Calendar cal = Calendar.getInstance();

		do {
			// get calendar title and create calendar value
			element(calendar_title).waitUntilVisible();
			String MandY = calendar_title.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy dd");
			cal.setTime(sdf.parse(MandY + " 1"));

			// go previous or next based on comparison
			if (cal.compareTo(calNew) == -1) {
				next_button.click();
			}
			if (cal.compareTo(calNew) == 1) {
				previous_button.click();
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
	
	public void click_save_button() {
		save_vac_req_button.click();
	}
}

