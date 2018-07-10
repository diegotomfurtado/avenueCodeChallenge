package com.diegotomfurtado.avenuecode.steps.createtasks;

import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.pages.MyTaskPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedirectUserToTaskPageStep {

	private WebDriver browser;
	HomePage home;
	MyTaskPage myTask;
	LoginPage login;

	// @Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

	// @After
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}

	/*
	 * Scenario 01
	 */

	@Given("^users already logged in$")
	public void usersAlreadyLoggedIn() throws Throwable {
		browser.findElement(linkText("Sign In")).click();

		login = new LoginPage(browser);
		login.fillEmailField("diegotomfurtado@gmail.com");
		login.fillPasswordField("tomtom123!");
		login.clickLogin();
	}

	@Given("^on home page$")
	public void onHomePage() throws Throwable {
		home = new HomePage(browser);
	}

	@When("^the user click on My Tasks link in navigation bar$")
	public void theUserClickOnMyTasksLinkInNavigationBar() throws Throwable {
		myTask = home.clickOnMyTaskButton();
	}

	@Then("^the user will be redirect to My Tasks page$")
	public void theUserWillBeRedirectToMyTasksPage() throws Throwable {
		myTask.findTableTaskOnPage();
	}

	@When("^the user to click on MyTasks button$")
	public void theUserToClickOnMyTasksButton() throws Throwable {
		myTask = home.clickTaksLinkFromNavigationBar();
	}

}
