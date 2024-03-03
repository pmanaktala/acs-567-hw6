package com.pmanaktala.acs567hw6.service;

import com.pmanaktala.acs567hw6.dto.TeamMemberDetails;

import java.util.List;

public interface TeamCapacityService {

    String calculateAverageTeamCapacity(int sprintDays, List<TeamMemberDetails> teamMembers);
    String calculateTeamCapacityRange(int sprintDays, List<TeamMemberDetails> teamMembers);
}
