package com.gev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Used by Timesheet
 */
public class Day {
    private Integer starttime;
    private Integer endtime;
    private Integer total;
    private boolean usefloating;
    private boolean usevacation;
    private Integer year;
}
