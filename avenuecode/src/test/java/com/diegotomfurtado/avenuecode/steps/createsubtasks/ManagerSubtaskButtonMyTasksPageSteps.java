package com.diegotomfurtado.avenuecode.steps.createsubtasks;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.linkText;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.diegotomfurtado.avenuecode.pages.HomePage;
import com.diegotomfurtado.avenuecode.pages.LoginPage;
import com.diegotomfurtado.avenuecode.pages.MyTaskPage;
import com.diegotomfurtado.avenuecode.setup.Setup;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerSubtaskButtonMyTasksPageSteps {

	private WebDriver browser;
	LoginPage logIn;
	HomePage home;
	MyTaskPage myTask;
	int numbersOfSubTasksFromLabel;
	int numbersOfSubtasks;

//	@Before
	public void setUpOpenBrowser() throws Exception {
		browser = Setup.setUpBrowser();
	}

	// @After
	public void teardown() throws Exception {
		browser.close();
		browser.quit();
	}

	@Given("^the user is logged in on MyTaskPage$")
	public void theUserIsLoggedInOnMyTaskPage() throws Throwable {
		browser.findElement(linkText("Sign In")).click();

		logIn = new LoginPage(browser);
		logIn.fillEmailField("diegotomfurtado@gmail.com");
		logIn.fillPasswordField("tomtom123!");
		logIn.clickLogin();

		new HomePage(browser).clickTaksLinkFromNavigationBar();
	}

	@When("^I see at least one \"([^\"]*)\" task created$")
	public void iSeeAtLeastOneTaskCreated(String task)
			throws NoSuchElementException {

		try {
			new MyTaskPage(browser).checkingLableManageSubtask();

		} catch (NoSuchElementException e) {
			new MyTaskPage(browser).typeNewTaskField(task).clickNewTaskButton();
		}
	}

	@Then("^I will confirm if the button lable there is \"([^\"]*)\"$")
	public void iWillConfirmIfTheButtonLableThereIs(String name)
			throws Throwable {

		assertTrue(new MyTaskPage(browser).checkingLableManageSubtask().contains(name));
	}

	@When("^I will get the subtasks numbers from the first task$")
	public void iWillGetTheSubtasksNumbersFromTheFirstTask() throws Throwable {
		
		String informationsSubTasksLabel = new MyTaskPage(browser).checkingLableManageSubtask();
		numbersOfSubTasksFromLabel = Integer.parseInt(informationsSubTasksLabel.substring(1,2));
	}
	
	@When("^I oppened the subtask popup to see the numbers of subtasks created$")
	public void iOppenedTheSubtaskPopupToSeeTheNumbersOfSubtasksCreated()
			throws Throwable {

		new MyTaskPage(browser).openSubTaksPouup();
		numbersOfSubtasks = (int)new MyTaskPage(browser).checkingANumberOfSubtasksCreated();

	}

	@Then("^I will compare the numbers from button lable on MyTask Page and the numbers from subtasks popUp$")
	public void iWillCompareTheNumbersFromButtonLableOnMyTaskPageAndTheNumbersFromSubtasksPopUp()
			throws Throwable {

		Assert.assertEquals(numbersOfSubTasksFromLabel, numbersOfSubtasks);
	}

}
