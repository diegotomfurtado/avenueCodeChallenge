@TestRun
Feature: Create Task
  Clicking MyTask link will redirect the user to a page with all the created tasks so far.
  Complementing the gols: testing all UIs to validate if the MyTask link is avaliable

  Background: 
    Given users already logged in

  Scenario: Should see TaskPage when the user to click on MyTask link from home
    Given on home page
    When the user click on My Tasks link in navigation bar
    Then the user will be redirect to My Tasks page

  Scenario: Should see TaskPage when the user to click on MyTask link from home
    Given on home page
    When the user to click on MyTasks button
    Then the user will be redirect to My Tasks page
