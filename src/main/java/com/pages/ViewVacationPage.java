package com.pages;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class ViewVacationPage extends PageObject{

	@FindBy(css = "li[class*='active-menu'] a[href*='menuItem=view-vacations']")
	public WebElementFacade viewVacations;
	
	@FindBy(css = "div[class='aui-column column-three column-center '] .aui-field-input")
	private List<WebElementFacade> daysNumber;
	
	@FindBy(css = "input[value='Apply']")
	public WebElementFacade applyButton;
	
	public void click_viewVacations() {
		viewVacations.waitUntilVisible();
		viewVacations.click();
	}
	
	public void set_days_number_filter(String interval){
		for (int i = 1; i < interval.length(); i++) {
			if (interval.charAt(i) == '1') {
				element(daysNumber.get(i)).click();
			}
		}
		System.out.println("Interval checked:");
	}
	
	public void click_apply(){
		applyButton.click();
	}

}
