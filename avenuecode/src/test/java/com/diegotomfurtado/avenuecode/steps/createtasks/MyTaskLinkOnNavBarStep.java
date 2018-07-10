package com.diegotomfurtado.avenuecode.steps.createtasks;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyTaskLinkOnNavBarStep {

	private WebDriver browser;
	HomePage home;
	boolean returnInfoLinkTask;

//	@Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

//	@After
	public void teardown() throws Exception {
		browser.close();
	}

	/*
	 * Scenario 01
	 */

	@Given("^User is already logged in$")
	public void userIsAlreadLoggedIn() throws Throwable {
		browser.findElement(linkText("Sign In")).click();

		LoginPage login = new LoginPage(browser);
		login.fillEmailField("diegotomfurtado@gmail.com");
		login.fillPasswordField("tomtom123!");
		login.clickLogin();
	}

	@And("^the user is on home page$")
	public void theUserIsOnHomePage() throws Throwable {
		home = new HomePage(browser);
	}

	@When("^the user look for My Tasks link in navigation bar$")
	public void theUserLookForMyTasksLinkInNavigationBar() throws Throwable {
		returnInfoLinkTask = home.findMyTaksLinkFromNavBar();
	}

	@Then("^the user should see the My Tasks link in the navigation bar$")
	public void theUserShouldSeeTheMyTasksLinkInTheNavigationBar()
			throws Throwable {
		assertEquals(true, returnInfoLinkTask);
	}

	/*
	 * Scenario 02
	 */


}
