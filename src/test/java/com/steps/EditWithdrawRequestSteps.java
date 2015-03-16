package com.steps;

import java.text.ParseException;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationReqPage;

public class EditWithdrawRequestSteps extends ScenarioSteps {

	NewVacationReqPage editWithdrawRequest;

	@Step
	public void clickNewVacationReq() {
		editWithdrawRequest.goToNewRequest();
	}

	/**
	 * @param date
	 *            format dd/mm/yyyy
	 * @throws ParseException
	 */
	@Step
	public void setStartDate(String date) throws ParseException {
		editWithdrawRequest.clickStartDate();
		editWithdrawRequest.settingDateByGivenParameter(date);
	}

	/**
	 * @param date
	 *            format dd/mm/yyyy
	 * @throws ParseException
	 */
	public void setEndDate(String date) throws ParseException {
		editWithdrawRequest.clickEndDate();
		editWithdrawRequest.settingDateByGivenParameter(date);

	}

	@Step
	public void setVacationType(String vacationType) {
		editWithdrawRequest.clickVacantionCheckbox(vacationType);
	}
	

	@Step
	public void selectSpecialReason(String specV) {
		editWithdrawRequest.selectSpecialReason(specV);
	}

	@Step
	public void addOptionalComment() {
		editWithdrawRequest.clickAddOptionalComment();
	}

	@Step
	public void addTextAreaComment(String comment) {
		editWithdrawRequest.addTextAreaComment(comment);
	}

	@Step
	public void clickEditVacationReq() {
		editWithdrawRequest.editVacationReqButton();
	}

	@Step
	public void clickSaveButton() {
		editWithdrawRequest.clickSaveButton();
	}
	
	@Step
	public void getSuccessMessage() {
		Assert.assertTrue("Your request completed successfully.",
				editWithdrawRequest.getSuccessMessage.isVisible());
	}
	
	@Step
	public void clickWithdrawButton() {
		editWithdrawRequest.clickWithdrawButton();
	}

	public void switchToEditFrame() {
		editWithdrawRequest.switchToEditFrame();
		
	}

}
