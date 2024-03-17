package com.pmanaktala.acs567hw6.steps;

import com.pmanaktala.acs567hw6.dto.TeamMemberDetails;
import com.pmanaktala.acs567hw6.service.TeamCapacityService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamCapacitySteps {

    private final List<TeamMemberDetails> teamMemberDetails = new ArrayList<>();

    @Autowired
    private TeamCapacityService teamCapacityService;

    private int sprintDays;
    private String result;

    @Given("a sprint lasting {int} days")
    public void a_sprint_lasting_days(Integer days) {
        this.sprintDays = days;
    }

    @Given("the following team member details")
    public void the_following_team_member_details(List<Map<String, Integer>> details) {
        // Assuming TeamMemberDetails constructor or a similar method to set values
        details.forEach(detailMap -> {
            TeamMemberDetails detail = new TeamMemberDetails(detailMap.get("daysOff"), detailMap.get("ceremonyDays"),
                    detailMap.get("hourRangeLow"), detailMap.get("hourRangeHigh"));
            teamMemberDetails.add(detail);
        });
    }

    @When("I calculate the team capacity range")
    public void i_calculate_the_team_capacity_range() {
        result = teamCapacityService.calculateTeamCapacityRange(sprintDays, teamMemberDetails);
    }

    @Then("the capacity range should be {string}")
    public void the_capacity_range_should_be(String expected) {
        assertEquals(expected, result);
    }
}
