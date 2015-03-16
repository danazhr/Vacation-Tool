package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class LogInPage extends PageObject {

	@FindBy(id = "sign-in")
	private WebElementFacade signInButton;

	@FindBy(id = "_58_login")
	private WebElementFacade username;

	@FindBy(id = "_58_password")
	private WebElementFacade password;

	@FindBy(css = "[type='submit']")
	private WebElementFacade login;
			
	public void enterUsername(String user) {
		username.type(user);
	}

	public void enterPassword(String pass) {
		password.type(pass);
	}

	public void login() {
		login.click();
	}

	public void goToLogin() {
		signInButton.click();
	}
}
