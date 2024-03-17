package com.pmanaktala.acs567hw6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberDetails {
    private int daysOff;
    private int ceremonyDays;
    private double hourRangeLow;
    private double hourRangeHigh;
}
