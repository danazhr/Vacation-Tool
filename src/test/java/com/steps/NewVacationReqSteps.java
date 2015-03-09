package com.steps;

import com.pages.NewVacationReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationReqSteps extends ScenarioSteps {

	NewVacationReqPage newVacationRequest;

	@Step
	public void click_newVacationReq() {
		newVacationRequest.go_to_new_request();
	}
	
	@Step
	public int get_businessDaysOutput(){
		return newVacationRequest.get_businessDaysOutput();
		}

}
