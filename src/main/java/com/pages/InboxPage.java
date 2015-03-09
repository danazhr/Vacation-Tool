package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class InboxPage extends PageObject{

	@FindBy (css="li.inactive-menu a[href*='menuItem=inbox']")
	public WebElementFacade inbox;
	
	public void click_inbox(){
		inbox.click();
	}
	
	
}
