package com.pmanaktala.acs567hw6.controller;

import com.pmanaktala.acs567hw6.dto.TeamMemberDetails;
import com.pmanaktala.acs567hw6.service.SprintVelocityService;
import com.pmanaktala.acs567hw6.service.TeamCapacityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing sprint calculations including team capacity and velocity.
 */
@RestController
@RequestMapping("/api/sprint")
public class SprintManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SprintManagementController.class);

    private final TeamCapacityService teamCapacityService;

    private final SprintVelocityService sprintVelocityService;

    public SprintManagementController(TeamCapacityService teamCapacityService,
                                      SprintVelocityService sprintVelocityService) {
        this.teamCapacityService = teamCapacityService;
        this.sprintVelocityService = sprintVelocityService;
    }

    /**
     * Calculates and returns the average team capacity for a given sprint.
     *
     * @param sprintDays  The number of days in the sprint.
     * @param teamMembers The details of each team member's availability and commitments.
     * @return A string representation of the average team capacity in person-hours.
     */
    @PostMapping("/calculateAverageTeamCapacity")
    public String calculateAverageTeamCapacity(@RequestParam int sprintDays,
                                               @RequestBody List<TeamMemberDetails> teamMembers) {
        LOGGER.info("Calculating average team capacity for a sprint of {} days.", sprintDays);
        return teamCapacityService.calculateAverageTeamCapacity(sprintDays, teamMembers);
    }

    /**
     * Calculates and returns the team's capacity range for a given sprint.
     *
     * @param sprintDays  The number of days in the sprint.
     * @param teamMembers The details of each team member's availability and commitments.
     * @return A string representing the total team capacity range in person-hours.
     */
    @PostMapping("/calculateTeamCapacityRange")
    public String calculateTeamCapacityRange(@RequestParam int sprintDays,
                                             @RequestBody List<TeamMemberDetails> teamMembers) {
        LOGGER.info("Calculating team capacity range for a sprint of {} days.", sprintDays);
        return teamCapacityService.calculateTeamCapacityRange(sprintDays, teamMembers);
    }

    /**
     * Calculates and returns the average velocity based on points completed in previous sprints.
     *
     * @param completedPoints A list of completed points from previous sprints.
     * @return The average velocity as a double.
     */
    @PostMapping("/calculateAverageVelocity")
    public double calculateAverageVelocity(@RequestBody List<Integer> completedPoints) {
        LOGGER.info("Calculating average velocity based on completed points.");
        return sprintVelocityService.calculateAverageVelocity(completedPoints);
    }
}

