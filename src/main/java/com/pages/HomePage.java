package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class HomePage extends PageObject {
	
	@FindBy(css = "a[href*='vacation']")
	private WebElementFacade vacation_button;
	
	public void go_to_vacation() {
		vacation_button.waitUntilVisible();
		vacation_button.click();
	}

}
