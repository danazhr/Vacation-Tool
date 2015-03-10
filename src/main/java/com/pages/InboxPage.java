package com.pages;

import java.util.List;




import org.junit.Assert;
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
	
	@FindBy(css ="td[class*='rowChecker'] input")
	public List<WebElement> check_boxes;
	
	
	@FindBy(css = "td[class*='employee-name']")
	public List<WebElement> names;
	
	@FindBy(css = "input[value='Approve']")
	public WebElementFacade approve_button;;

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

	public void select_request(String employee, String startDate){
		for(WebElement name : names){
			if (name.getText().contains(employee)){
				for(int i = 0; i < startDates.size(); i++){
					if(startDates.get(i).getText().contains(startDate)){
						check_boxes.get(i).click();
					}
				}
				break;
			}
		}

	}
	
	public void click_approve_button(){
		approve_button.click();
	}


	public void check_if_selected_request_was_approved(String employee,
			String startDate) {
		boolean found = false;
		for (WebElement name : names) {
			if (name.getText().contains(employee)) {
				for (int i = 0; i < startDates.size(); i++) {
					if (startDates.get(i).getText().contains(startDate)) {
						found = true;
					}
				}
				break;
			}
		}
		Assert.assertFalse("Request was found!", found);
	}
}
