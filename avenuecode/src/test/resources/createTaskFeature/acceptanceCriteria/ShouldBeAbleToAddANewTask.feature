Feature: Create Task
  The user should be able to enter a new task by hitting enter or clicking on the add task
  button.

  Background: 
    Given the user is already logged in on MyTaskPage

  @ignore
  Scenario: Adding a new task by Enter with empty string
    When I fill empty string "  " and press ENTER by key of keyboard
    Then the system should show the message "Preencha este campo."

  @ignore
  Scenario: Adding a new task by button with empty string
    When I fill empty string "  " and press the button
    Then I should not see empty tasks created

  @ignore
  Scenario Outline: The task should require at least three characters so the user can enter it.
    When I type three characters "<minCaracters>" on task description textbox and press key
    Then the system will create a new task "<minCaracters>"
    And I will compare "<minCaracters>" how many characters there are.

    Examples: 
      | minCaracters |
      | tom          |
      | to           |

  @ignore
  Scenario Outline: The task can not have more than 250 characters
    When I type "<two hundred and fifty>" characters on task description textbox and press the newTask button
    Then the system will create a new task with with all "<two hundred and fifty>" characters
    And I will compare "<two hundred and fifty>" how many characters there are.

    Examples: 
      | two hundred and fifty                                                                                                                                                                                                                                       |
      | What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industrys standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type s  |
      | What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industrys standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type s2 |

  @ignore
  Scenario: adding N characters the task should be appended on the list of created tasks.
    When I written some characters on task description textbox and press the newTask button
    Then the system will append on the list the same characters I have written
