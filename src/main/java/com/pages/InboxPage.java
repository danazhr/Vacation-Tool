package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class InboxPage extends PageObject {

	//@FindBy(css = "li.active-menu a[href*='menuItem=inbox']")
	@FindBy(css = "li[class*='active-menu'] a[href*='menuItem=inbox']")
	public WebElementFacade inbox;

	@FindBy(css = "td[class*='start.date']")
	public List<WebElement> startDates;

	public void click_inbox() {
		inbox.waitUntilVisible();
		inbox.click();
	}

	public int get_inbox_requests_number() {
		String numberOnly = inbox.getText().replaceAll("[^0-9]", "");
		return Integer.parseInt(numberOnly);
	}

	public int get_table_requests_number() {
		return startDates.size();
	}

}
