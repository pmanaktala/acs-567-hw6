package com.pmanaktala.acs567hw6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamMemberDetails {
    private int daysOff;
    private int ceremonyDays;
    private double hourRangeLow;
    private double hourRangeHigh;
}
