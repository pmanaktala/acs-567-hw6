package com.pmanaktala.acs567hw6.controller;

import com.pmanaktala.acs567hw6.service.SprintVelocityService;
import com.pmanaktala.acs567hw6.service.TeamCapacityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SprintManagementControllerTests {

    @MockBean
    private TeamCapacityService teamCapacityService;

    @MockBean
    private SprintVelocityService sprintVelocityService;

    @Autowired
    private MockMvc mvc;

    @Test
    void calculateAverageTeamCapacityTest_success() throws Exception {

        Mockito.when(sprintVelocityService.calculateAverageVelocity(Mockito.anyList())).thenReturn(10.0D);

        mvc.perform(post("/api/sprint/calculateAverageVelocity").content("[8, 13, 21, 5, 8, 10]")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void calculateAverageTeamCapacityTest_error404() throws Exception {

        Mockito.when(sprintVelocityService.calculateAverageVelocity(Mockito.anyList())).thenReturn(10.0D);

        mvc.perform(post("/api/sprints/calculateAverageVelocity").content("[8, 13, 21, 5, 8, 10]")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }

    @Test
    void calculateTeamCapacityRange_success() throws Exception {

        Mockito.when(teamCapacityService.calculateAverageTeamCapacity(Mockito.anyInt(), Mockito.anyList()))
                .thenReturn("{}");

        mvc.perform(post("/api/sprint/calculateAverageTeamCapacity?sprintDays=14").content("""
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
                ]""").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void calculateAverageVelocity_success() throws Exception {

        Mockito.when(teamCapacityService.calculateTeamCapacityRange(Mockito.anyInt(), Mockito.anyList()))
                .thenReturn("{}");

        mvc.perform(post("/api/sprint/calculateTeamCapacityRange?sprintDays=14").content("""
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
                ]""").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


}
