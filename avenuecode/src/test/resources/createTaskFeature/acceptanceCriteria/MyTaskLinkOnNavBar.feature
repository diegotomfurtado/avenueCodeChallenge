Feature: Create Task
  I should be able to create a task So I can manage my tasks

  Background: 
    Given User is already logged in

  @ignore
  Scenario: Should see [My tasks] link on NavBar from HomePage when user is logged in
    And the user is on home page
    When the user look for My Tasks link in navigation bar
    Then the user should see the My Tasks link in the navigation bar
