@TestRun
Feature: Create SubTask
  The user should see a button labeled as ‘Manage Subtasks’.

  Background: 
    Given a user is logged in on MyTaskPage
    Given I am on subtask popup page

  Scenario: Validate if task description is read only field
    And I have got the taskId
    When I enter "Teste Depois" in task description textbox
    Then I should not see any changes to the text of task

  Scenario Outline: There should be a form so you can enter the SubTask Description (250
    characters)

    When I enter "<two hundred and fifty>" in Sub Task description field
    Then I should see the subtask of "<two hundred and fifty>" successfully created

    Examples: 
      | two hundred and fifty                                                                                                                                                                                                                                       |
      | What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industrys standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type s  |
      | What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industrys standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type s2 |
