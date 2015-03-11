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

public class NewVacationReqPage extends PageObject {
	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade new_vacation_button;

	@FindBy(css = "#selectedDaysContainer #businessDaysOutput")
	private WebElementFacade businessDaysOutput;

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
	
	/*@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CO']")
	private WebElementFacade holiday;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade vacationWithoutPayment;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade specialVacation;
	
	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CM']")
	private WebElementFacade sickLeave;*/

	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade specialReason;

	@FindBy(css = "div#_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElementFacade addComment;

	@FindBy(css = "textarea[name='commentContent']")
	private WebElementFacade textAreaComment;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveVacReqButton;

	@FindBy(css = ".vacationTypeChoice label")
	private List<WebElement> selectVacationTypeList;

	/*
	 * @FindBy(css = "div.portlet-msg-error:first-child") private
	 * WebElementFacade getFirstErrorMessage;
	 */

	public void click_StartDate() {
		startDateButton.click();
	}
	
	public void clickVacantionCheckbox(String vacationType) {
		  List<WebElement> VacationTypes = getDriver().findElements(
		    By.cssSelector("div[class='vacationTypeChoice'] label"));
		  for (WebElement type : VacationTypes) {
		   if (type.getText().toLowerCase().equals(vacationType.toLowerCase()))
		    type.click();
			}
		}
	

	/*
	 * public void getFirstErrorMessage(){ Assert.assertTrue("Test Failed!",
	 * getFirstErrorMessage
	 * .getText().toLowerCase().contains(" Your request failed to complete."
	 * .toLowerCase())); }
	 */

	public void click_EndDate() {
		endDateButton.click();
	}

	public void go_to_new_request() {
		new_vacation_button.click();
	}

	public void selectNewVacationType() {
		//selectNewVacationType.
	}

	/*public int get_businessDaysOutput() {
		System.out.println(businessDaysOutput.getText());
		return Integer.parseInt(businessDaysOutput.getText());
	}*/
	
	/*public void click_holiday() {
		holiday.click();
	}
	
	public void click_vacationWithoutPayment() {
		vacationWithoutPayment.click();
	}
	
	
	public void click_special_vacation() {
		specialVacation.click();
	}
	
	public void click_sickLeave() {
		sickLeave.click();
	}*/
	
	public void selectSpecialReason(String specV) {
		specialReason.selectByVisibleText(specV).click();
	}

	public void clickForAddComment() {
		addComment.click();
	}

	public void addTextAreaComment(String comment) {
		textAreaComment.type(comment);
	}

	public void clickSaveButton() {
		saveVacReqButton.click();
	}

	
	public void settingDateByGivenParameter(String date) throws ParseException {
		
		String[] dateList = date.split("/");
		
		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + dateList[1] + "/"
				+ dateList[2]));

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

}
