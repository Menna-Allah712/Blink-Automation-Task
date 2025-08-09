Feature: Blog Page Subscription Form

  Background:
    Given I am on the Blink22 blog page

  Scenario: Verify placeholder text for Full Name field
    When I check the Full Name placeholder
    Then I should see placeholder with name

  Scenario: Verify placeholder text for Email field
    When I check the Email placeholder
    Then I should see placeholder with email

  Scenario: User can enter Full Name
    When I enter "John Smith" in the Full Name box
    Then the Full Name box should contain "John Smith"

  Scenario: User can enter valid email
    When I enter "test@example.com" in the Email box
    Then the Email box should contain "test@example.com"

  Scenario: Form cannot be submitted when Full Name is empty
    When I enter "test@example.com" in the Email box
    And I click Subscribe
    Then I should see Full Name error message "This field is required."

  Scenario: Form cannot be submitted when Email is empty
    When I enter "John Smith" in the Full Name box
    And I click Subscribe
    Then I should see Email error message "This field is required."

  Scenario: Form cannot be submitted with invalid email
    When I enter "John Smith" in the Full Name box
    And I enter "test@com" in the Email box
    And I click Subscribe
    Then I should see Email error message "Enter a valid email address."

  Scenario: Form shows Thank You message with valid data
    When I enter "John Smith" in the Full Name box
    And I enter "test@example.com" in the Email box
    And I click Subscribe
    Then I should see Thanks message "Thanks"