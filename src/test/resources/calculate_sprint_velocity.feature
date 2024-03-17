Feature: Calculate Sprint Team Velocity

  Scenario: Calculate average velocity for completed sprints
    Given the following sprint points: "8, 13, 21, 5, 8, 10"
    When I calculate the average velocity
    Then the average velocity should be 10.83

  Scenario: Calculate average velocity with an empty list of sprint points
    Given the following sprint points: ""
    When I calculate the average velocity
    Then the average velocity should be 0