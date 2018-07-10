Feature: Create Task
  The user should see a message on the top part saying that list belongs to the logged
  user

  Background: 
    Given considering the user already logged in

  @ignore
  Scenario: Showing to users the tasks confirmation message on the top
    When the user is on myTask page
    Then the user will see their confirmation task message
