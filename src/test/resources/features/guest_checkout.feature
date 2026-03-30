Feature: Guest Checkout on OpenCart

  Scenario: Complete a guest checkout with two products
    Given the user is on the OpenCart store home page
    When the user adds "MacBook" to the cart
    And the user adds "iPhone" to the cart
    And the user views the shopping cart
    And the user proceeds to checkout as guest
    And the user fills in the billing details as a guest
    And the user selects the delivery method
    And the user selects the payment method
    And the user confirms the order
    Then the user should see the message "Your order has been placed!"
