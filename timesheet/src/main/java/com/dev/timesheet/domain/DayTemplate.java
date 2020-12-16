package com.dev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@QueryEntity
/**
 * Used by Template
 */
public class DayTemplate {
    private Integer starttime;
    private Integer endtime;
    private Integer total;
    private boolean usefloating;
    private boolean usevacation;
}
