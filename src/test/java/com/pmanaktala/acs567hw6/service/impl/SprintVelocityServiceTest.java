package com.pmanaktala.acs567hw6.service.impl;

import com.pmanaktala.acs567hw6.service.SprintVelocityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class SprintVelocityServiceTest {

    @Autowired
    private SprintVelocityService sprintVelocityService;

    @Test
    void testSpringVelocityService_emptyCompletedPoints_success() {
        Assertions.assertEquals(0, sprintVelocityService.calculateAverageVelocity(Collections.emptyList()),
                "Expected 0 for empty list");
    }

    @Test
    void testSpringVelocityService_nonEmptyCompletedPoints_success() {
        Assertions.assertEquals(2.5, sprintVelocityService.calculateAverageVelocity(List.of(1, 2, 3, 4)),
                "Expected 2.5 as average velocity");
    }
}
