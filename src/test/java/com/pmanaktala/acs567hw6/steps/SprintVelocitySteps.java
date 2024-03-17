package com.pmanaktala.acs567hw6.steps;

import com.pmanaktala.acs567hw6.service.SprintVelocityService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SprintVelocitySteps {

    @Autowired
    private SprintVelocityService sprintVelocityService;

    private List<Integer> sprintPoints;
    private double result; // Mocked result for demonstration

    @Given("the following sprint points: {string}")
    public void the_following_sprint_points(String points) {
        sprintPoints = Arrays.stream(points.split(",")).map(String::trim).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @When("I calculate the average velocity")
    public void i_calculate_the_average_velocity() {
        this.result = sprintVelocityService.calculateAverageVelocity(sprintPoints);
    }

    @Then("the average velocity should be {double}")
    public void the_average_velocity_should_be(Double expected) {
        assertEquals(expected, result, 0.01);
    }
}

