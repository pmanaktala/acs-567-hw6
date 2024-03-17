package com.pmanaktala.acs567hw6.service.impl;

import com.pmanaktala.acs567hw6.dto.TeamMemberDetails;
import com.pmanaktala.acs567hw6.service.TeamCapacityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamCapacityServiceImpl implements TeamCapacityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamCapacityServiceImpl.class);


    /**
     * Calculates the average team capacity in person-hours for a given sprint.
     * The calculation takes into account each team member's available hours (low to high range),
     * days off, and days committed to ceremonies, to estimate the total average capacity.
     *
     * @param sprintDays  The number of days in the sprint.
     * @param teamMembers A list of {@link TeamMemberDetails} representing the team members' availability and
     *                    commitments.
     * @return A string representation of the average total capacity in person-hours.
     */
    @Override
    public String calculateAverageTeamCapacity(int sprintDays, List<TeamMemberDetails> teamMembers) {
        if (sprintDays <= 0) {
            throw new RuntimeException("Sprint days must be greater than 0");
        }

        double totalCapacity = 0.0;

        for (TeamMemberDetails member : teamMembers) {
            int effectiveDays = sprintDays - member.getDaysOff() - member.getCeremonyDays();
            double dailyAverageHours = (member.getHourRangeLow() + member.getHourRangeHigh()) / 2;

            totalCapacity += effectiveDays * dailyAverageHours;
        }

        String result = String.format("Average Capacity: %.2f person-hours", totalCapacity);
        LOGGER.info("Calculated {}", result);

        return result;
    }

    /**
     * Calculates the team's total capacity range for a sprint, based on each team member's availability.
     *
     * @param sprintDays  The number of days in the sprint.
     * @param teamMembers A list of {@link TeamMemberDetails} representing each team member's availability and
     *                    commitments.
     * @return The total team capacity range as a double, representing the sum of the low and high hourly ranges
     * across all team members and sprint days.
     */
    @Override
    public String calculateTeamCapacityRange(int sprintDays, List<TeamMemberDetails> teamMembers) {
        if (sprintDays <= 0) {
            throw new RuntimeException("Sprint days must be greater than 0");
        }

        double totalMinCapacity = 0;
        double totalMaxCapacity = 0;

        for (TeamMemberDetails member : teamMembers) {
            int effectiveDays = sprintDays - member.getDaysOff() - member.getCeremonyDays();
            double dailyMinCapacity = member.getHourRangeLow();
            double dailyMaxCapacity = member.getHourRangeHigh();

            // Ensure effectiveDays is not negative, which can happen if days off and ceremony days exceed sprintDays
            effectiveDays = Math.max(effectiveDays, 0);

            totalMinCapacity += effectiveDays * dailyMinCapacity;
            totalMaxCapacity += effectiveDays * dailyMaxCapacity;
        }


        String result = String.format("Capacity Range : %f - %f person hours", totalMinCapacity, totalMaxCapacity);
        LOGGER.info("Calculated {}", result);

        return result;
    }
}
