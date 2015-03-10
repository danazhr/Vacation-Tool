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

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade concediuSpecial;
	
	@FindBy(css = "select[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade specialReason;
	
	@FindBy(css = "div#_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElementFacade addComment;
	
	@FindBy(css = "textarea[name='commentContent']")
	private WebElementFacade textAreaComment;

	public void click_StartDate() {
		startDateButton.click();
	}

	public void click_EndDate() {
		endDateButton.click();
	}

	public void go_to_new_request() {
		new_vacation_button.click();
	}

	public int get_businessDaysOutput() {
		System.out.println(businessDaysOutput.getText());
		return Integer.parseInt(businessDaysOutput.getText());

	}
	
	public void click_concediuSpecial(){
		concediuSpecial.click();
	}
	
	public void selectSpecialReason(String specV){
		specialReason.selectByVisibleText(specV).click();
	}
	
	public void clickForAddComment(){
		addComment.click();
	}
	
	public void addTextAreaComment(String comment){
		textAreaComment.type(comment);
	}
	

	public void settingDateByGivenParameter(int month, int day, int year)
			throws ParseException {

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + String.valueOf(month) + "/"
				+ String.valueOf(year)));

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
			if (currentDay.getText().contentEquals(String.valueOf(day)))
				currentDay.click();
		}

	}

}
