package com.pmanaktala.acs567hw6.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmanaktala.acs567hw6.dto.TeamMemberDetails;
import com.pmanaktala.acs567hw6.service.TeamCapacityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeamCapacityServiceTest {

    @Autowired
    private TeamCapacityService teamCapacityService;

    @Test
    void testSpringVelocityService_velocityRange_success() throws JsonProcessingException {
        List<TeamMemberDetails> teamMemberDetails = new ObjectMapper().readValue("""
                [
                    {
                        "daysOff": 2,
                        "ceremonyDays": 1,
                        "hourRangeLow": 4,
                        "hourRangeHigh": 6
                    },
                    {
                        "daysOff": 1,
                        "ceremonyDays": 1,
                        "hourRangeLow": 5,
                        "hourRangeHigh": 7
                    }
                ]
                """, new TypeReference<>() {
        });
        Assertions.assertEquals("Capacity Range : 104.000000 - 150.000000 person hours",
                teamCapacityService.calculateTeamCapacityRange(14, teamMemberDetails), "Expected non zero for list");
    }

    @Test
    void testSpringVelocityService_averageVelocity_success() throws JsonProcessingException {
        List<TeamMemberDetails> teamMemberDetails = new ObjectMapper().readValue("""
                [
                    {
                        "daysOff": 2,
                        "ceremonyDays": 1,
                        "hourRangeLow": 4,
                        "hourRangeHigh": 6
                    },
                    {
                        "daysOff": 1,
                        "ceremonyDays": 1,
                        "hourRangeLow": 5,
                        "hourRangeHigh": 7
                    }
                ]
                """, new TypeReference<>() {
        });
        Assertions.assertEquals("Average Capacity: 127.00 person-hours",
                teamCapacityService.calculateAverageTeamCapacity(14, teamMemberDetails), "Expected non zero for list");
    }
}
