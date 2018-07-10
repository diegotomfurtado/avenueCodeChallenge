package com.diegotomfurtado.avenuecode.testsuit;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		features = {
			"src/test/resources/createTaskFeature/acceptanceCriteria/MyTaskLinkOnNavBar.feature",
			"src/test/resources/createTaskFeature/acceptanceCriteria/RedirectUserToTaskPage.feature",
			"src/test/resources/createTaskFeature/acceptanceCriteria/TaskConfirmationMessageBelongingToUser.feature",
			"src/test/resources/createTaskFeature/acceptanceCriteria/ShouldBeAbleToAddANewTask.feature",
			"src/test/resources/createSubTask/acceptanceCriteria/ManagerSubTasksPage.feature",
			"src/test/resources/createSubTask/acceptanceCriteria/ManagerSubtaskButtonMyTasksPage.feature"},
		glue = { "com.diegotomfurtado.avenuecode.steps"}, 
		tags = {
			"@TestRun",
			"~@ignore" 
		})
public class ExecutionSuites {

}
