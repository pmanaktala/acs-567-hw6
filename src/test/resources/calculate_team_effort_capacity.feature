Feature: Calculate Team Effort-Hour Capacity

  Scenario: Calculate team effort-hour capacity
    Given a sprint lasting 14 days
    And the following team member details
      | daysOff | ceremonyDays | hourRangeLow | hourRangeHigh |
      | 2       | 1            | 4            | 6             |
      | 1       | 1            | 5            | 7             |
    When I calculate the team capacity range
    Then the capacity range should be "Capacity Range : 104.000000 - 150.000000 person hours"

  Scenario: Calculate team effort-hour capacity with invalid team member details
    Given a sprint lasting -1 days
    And the following team member details
      | daysOff | ceremonyDays | hourRangeLow | hourRangeHigh |
      | 10      | 1            | 4            | 6             |
    When I attempt to calculate the team capacity range
    Then I should receive an error message "Sprint days must be greater than 0"