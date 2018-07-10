package com.diegotomfurtado.avenuecode.steps.createtasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.linkText;

import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.pages.MyTaskPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShouldBeAbleToAddANewTaskStep {

	private WebDriver browser;
	LoginPage logIn;
	HomePage home;
	MyTaskPage myTask;

	 @Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

	 @After
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}

	@Given("^the user is already logged in on MyTaskPage$")
	public void theUserIsAlreadyLoggedInOnMyTaskPage() throws Throwable {
		browser.findElement(linkText("Sign In")).click();

		logIn = new LoginPage(browser);
		logIn.fillEmailField("diegotomfurtado@gmail.com");
		logIn.fillPasswordField("tomtom123!");
		logIn.clickLogin();

		new HomePage(browser).clickTaksLinkFromNavigationBar();
	}

	@When("^I fill empty string \"([^\"]*)\" and press ENTER by key of keyboard$")
	public void iFillEmptyStringAndPressENTERByKeyKeyboard(String name)
			throws Throwable {
		new MyTaskPage(browser).typeNewTaskField(name)
				.clickNewTaskBykeyOfKeyboard();
	}

	@Then("^the system should show the message \"([^\"]*)\"$")
	public void theSystemShouldShowTheMessage(String nameNewTask)
			throws Throwable {

		assertTrue("Preencha este campo.".contains(new MyTaskPage(browser)
				.returnAlertMessageNewTaskEmptyField()));
	}

	@When("^I fill empty string \"([^\"]*)\" and press the button$")
	public void iFillEmptyStringAndPressTheButton(String name) throws Throwable {

		new MyTaskPage(browser).typeNewTaskField(name).clickNewTaskButton();
	}

	@Then("^I should not see empty tasks created$")
	public void iShouldNotSeeEmptyTasksCreated() throws Throwable {

		assertTrue(!"empty".contains(new MyTaskPage(browser)
				.checkingEmptyTaskAfterAddingEmptyString()));
	}

	@When("^I type three characters \"([^\"]*)\" on task description textbox and press key$")
	public void iTypeThreeCharactersOnTaskDescriptionTextboxAndPressKey(
			String name) throws Throwable {

		new MyTaskPage(browser).typeNewTaskField(name).clickNewTaskButton();
	}

	@Then("^the system will create a new task \"([^\"]*)\"$")
	public void theSystemWillCreateANewTask(String name) throws Throwable {

		assertEquals(name, new MyTaskPage(browser).checkingNewTaskCreated());
	}

	@Then("^I will compare \"([^\"]*)\" how many characters there are\\.$")
	public void iWillCompareHowManyCharactersThereAre(String name)
			throws Throwable {

		if (name.length() < 3 || name.length() >= 250) {
			assertFalse("Limite mínimo ou máximo de caracters estrapolado.",
					true);
		}
	}

	@When("^I type \"([^\"]*)\" characters on task description textbox and press the newTask button$")
	public void iTypeCharactersOnTaskDescriptionTextboxAndPressTheNewTaskButton(
			String name) throws Throwable {

		new MyTaskPage(browser).typeNewTaskField(name).clickNewTaskButton();
	}

	@Then("^the system will create a new task with with all \"([^\"]*)\" characters$")
	public void theSystemWillCreateANewTaskWithWithAllCharacters(String name)
			throws Throwable {

		if (name.length() <= 250) {
			assertEquals(name, new MyTaskPage(browser).checkingNewTaskCreated());
		} else {
			assertFalse("Limite de caracters estrapolado.", name.length() > 250);
		}
	}

	@When("^I written some characters on task description textbox and press the newTask button$")
	public void iWrittenSomeCharactersOnTaskDescriptionTextboxAndPressTheNewTaskButton()
			throws Throwable {

		new MyTaskPage(browser).typeNewTaskField(
				"Test to ckeck an append on the task list")
				.clickNewTaskButton();
	}

	@Then("^the system will append on the list the same characters I have written$")
	public void theSystemWillAppendOnTheListTheSameCharactersIHaveWritten()
			throws Throwable {

		assertEquals("Test to ckeck an append on the task list",
				new MyTaskPage(browser).checkingNewTaskCreated());
	}
}
