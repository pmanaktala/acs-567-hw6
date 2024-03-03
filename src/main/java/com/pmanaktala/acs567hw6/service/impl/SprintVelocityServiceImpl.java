package com.pmanaktala.acs567hw6.service.impl;

import com.pmanaktala.acs567hw6.service.SprintVelocityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintVelocityServiceImpl implements SprintVelocityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SprintVelocityServiceImpl.class);

    /**
     * Calculates the average velocity based on the points completed in previous sprints.
     *
     * @param completedPoints A list of integers representing the points completed in each sprint.
     * @return The average velocity as a double. If the list is empty, returns 0.
     */
    public double calculateAverageVelocity(List<Integer> completedPoints) {
        if (completedPoints.isEmpty()) {
            LOGGER.info("No completed points provided. Returning average velocity as 0.");
            return 0;
        }

        int totalPoints = completedPoints.stream().mapToInt(Integer::intValue).sum();
        double averageVelocity = (double) totalPoints / completedPoints.size();

        LOGGER.info("Calculated average velocity: {}", averageVelocity);
        return averageVelocity;
    }
}
