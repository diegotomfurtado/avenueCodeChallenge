package com.diegotomfurtado.avenuecode.setup;

import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.LoginPage;

public class GenericMethodToLogIn {

	public WebDriver browser;
	LoginPage login;

	public GenericMethodToLogIn genericMethodToLogIn() {

		browser.findElement(linkText("Sign In")).click();

		login = new LoginPage(browser);
		login.fillEmailField("diegotomfurtado@gmail.com");
		login.fillPasswordField("tomtom123!");
		login.clickLogin();

		return this;
	}
}
