package com.diegotomfurtado.avenuecode.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePages {

	private final By userEmailLocator = id("user_email");
	private final By passwordFieldLocator = id("user_password");
	private final By loginButtonLocator = xpath(".//input[@class='btn btn-primary']");

	public LoginPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public LoginPage fillEmailField(String email) {
		browser.findElement(userEmailLocator).sendKeys(email);
		return this;
	}

	public LoginPage fillPasswordField(String password) {
		browser.findElement(passwordFieldLocator).sendKeys(password);
		return this;
	}

	public MyTaskPage clickLogin() {
		browser.findElement(loginButtonLocator).click();
		return new MyTaskPage(browser);
	}

}
