Feature: Calculate Team Effort-Hour Capacity

  Scenario: Calculate team effort-hour capacity
    Given a sprint lasting 14 days
    And the following team member details
      | daysOff | ceremonyDays | hourRangeLow | hourRangeHigh |
      | 2       | 1            | 4            | 6             |
      | 1       | 1            | 5            | 7             |
    When I calculate the team capacity range
    Then the capacity range should be "Capacity Range : 104.000000 - 150.000000 person hours"
