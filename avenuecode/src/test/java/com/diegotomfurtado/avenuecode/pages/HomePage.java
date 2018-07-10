package com.diegotomfurtado.avenuecode.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePages {

	private final By taskNavBarLocator = xpath(".//div[contains(@class, 'navbar-collapse')]//a[contains(@href,'/tasks')]");
	private final By signInButtonLocator = xpath(".//ul[contains(@class,\"nav navbar-nav navbar-right\")]//a[contains(@href,'/sign_in')]");
	private final By myTasksButtonLocator = xpath(".//a[contains(@class, 'btn btn-lg btn-success')]");

	public HomePage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public MyTaskPage clickTaksLinkFromNavigationBar() {
		browser.findElement(taskNavBarLocator).click();
		return new MyTaskPage(browser);
	}

	public boolean findMyTaksLinkFromNavBar() {
		return browser.findElement(taskNavBarLocator).isDisplayed();
	}

	public boolean findSignInButtonInHomePage() {
		return browser.findElement(signInButtonLocator).isDisplayed();
	}

	public MyTaskPage clickOnMyTaskButton() {
		browser.findElement(myTasksButtonLocator).click();
		return new MyTaskPage(browser);
	}
}
