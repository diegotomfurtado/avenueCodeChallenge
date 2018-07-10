@TestRun
Feature: Create SubTask
  The user should see a button labeled as ‘Manage Subtasks’.

  Background: 
    Given the user is logged in on MyTaskPage

  Scenario: Checking if the button lable is Manage Subtask
    When I see at least one "oneTask" task created
    Then I will confirm if the button lable there is "Manage Subtasks"

  Scenario: This button should have the number of subtasks created for that tasks
    When I see at least one "oneTask" task created
    And I will get the subtasks numbers from the first task
    And I oppened the subtask popup to see the numbers of subtasks created
    Then I will compare the numbers from button lable on MyTask Page and the numbers from subtasks popUp
