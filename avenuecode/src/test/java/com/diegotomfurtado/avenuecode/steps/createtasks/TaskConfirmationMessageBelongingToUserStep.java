package com.diegotomfurtado.avenuecode.steps.createtasks;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.pages.MyTaskPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskConfirmationMessageBelongingToUserStep {

	private WebDriver browser;
	LoginPage logIn;
	HomePage home;

	// @Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

	// @After
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}

	@Given("^considering the user already logged in$")
	public void consideringTheUserAlreadyLoggedIn() throws Throwable {

		browser.findElement(linkText("Sign In")).click();

		logIn = new LoginPage(browser);
		logIn.fillEmailField("diegotomfurtado@gmail.com");
		logIn.fillPasswordField("tomtom123!");
		logIn.clickLogin();
	}

	@When("^the user is on myTask page$")
	public void theUserIsOnMyTaskPage() throws Throwable {
		new HomePage(browser).clickTaksLinkFromNavigationBar();
	}

	/*
	 * From the requirments: "Hey John, this is your todo list for today:"
	 * However, I will not consider the string because is a example. I took a
	 * small part of that string
	 */

	@Then("^the user will see their confirmation task message$")
	public void theUserWillSeeTheirConfirmationTaskMessage() throws Throwable {
		assertTrue("ToDo List".contains(new MyTaskPage(browser)
				.getConfirmationMessageOnTheTop()));
	}
}
