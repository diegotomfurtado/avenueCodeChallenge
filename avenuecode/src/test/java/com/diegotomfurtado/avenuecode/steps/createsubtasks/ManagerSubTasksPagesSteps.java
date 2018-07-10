package com.diegotomfurtado.avenuecode.steps.createsubtasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.pages.MyTaskPage;
import com.diegotomfurtado.avenuecode.pages.SubTaskPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerSubTasksPagesSteps {

	private WebDriver browser;
	LoginPage logIn;
	HomePage home;
	SubTaskPage subTask;
	String taskNameIdBefore;
	String taskNameIdAfter;

	@Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

	@After
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}

	@Given("^a user is logged in on MyTaskPage$")
	public void aUserIsLoggedInOnMyTaskPage() throws Throwable {

		browser.findElement(linkText("Sign In")).click();

		logIn = new LoginPage(browser);
		logIn.fillEmailField("diegotomfurtado@gmail.com");
		logIn.fillPasswordField("tomtom123!");
		logIn.clickLogin();

		new HomePage(browser).clickTaksLinkFromNavigationBar();
	}

	@Given("^I am on subtask popup page$")
	public void iAmOnSubtaskPopupPage() throws Throwable {

		taskNameIdBefore = new MyTaskPage(browser).taskIdNameFromMyTaskPage();
		subTask = new MyTaskPage(browser).openSubTaksPouup();
	}

	@Given("^I have got the taskId$")
	public void iHaveGotTheTaskId() throws Throwable {

		// taskNameId = subTask.getTaskNameId();
		System.out.println("NOME: " + taskNameIdBefore);
	}

	@When("^I enter \"([^\"]*)\" in task description textbox$")
	public void iEnterInTaskDescriptionTextbox(String name) throws Throwable {

		subTask.enterValueOnTaskIdField(name);
	}

	@Then("^I should not see any changes to the text of task$")
	public void iShouldNotSeeAnyChangesToTheTextOfTask() throws Throwable {
		taskNameIdAfter = new MyTaskPage(browser).taskIdNameFromMyTaskPage();
		assertEquals(taskNameIdBefore, taskNameIdAfter);
	}

	@When("^I enter \"([^\"]*)\" in Sub Task description field$")
	public void iEnterInSubTaskDescriptionField(String name) throws Throwable {

		new SubTaskPage(browser).enterValueOnSubTaskIdDescriptionField(name)
				.clickOnAddSubtaskButton();
	}

	@Then("^I should see the subtask of \"([^\"]*)\" successfully created$")
	public void iShouldSeeTheSubtaskOfSuccessfullyCreated(String name)
			throws Throwable {

		if (name.length() <= 250) {
			assertEquals(name,
					new SubTaskPage(browser)
							.checkingStringFromDescriptionField());
		} else {
			assertFalse("Limite de caracters estrapolado.", name.length() > 250);
		}
	}

}
