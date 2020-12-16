package com.gev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document(collection = "Timesheet")
@CompoundIndexes({
        @CompoundIndex(name = "userid_date", def = "{userid:1, weekending:-1}", unique = true)
})
public class Timesheet {
    @Id
    @ApiModelProperty(notes = "The database generated timesheet ID")
    private String id;

    @ApiModelProperty(notes = "Timesheet userID", required = true)
    private String userid;

    @ApiModelProperty(notes = "Timesheet last day of the week", required = true)
    private String weekending;

    @ApiModelProperty(notes = "Timesheet total billing hours")
    private Integer totalhours;

    @ApiModelProperty(notes = "Timesheet total compensated hours")
    private Integer totalcompensatedhours;

    @ApiModelProperty(notes = "Timesheet submission info: Not Started, Complete, Incomplete")
    private String submission;

    @ApiModelProperty(notes = "Timesheet approval info: Approved, Not approved, N/A")
    private String approval;// once "Approved", no "Edit" in option

    @ApiModelProperty(notes = "Timesheet user option: Edit, View")
    private String option;

    @ApiModelProperty(notes = "Timesheet comments")
    private String comment;

    @ApiModelProperty(notes = "Timesheet Sunday record")
    private Day day1;

    @ApiModelProperty(notes = "Timesheet Monday record")
    private Day day2;

    @ApiModelProperty(notes = "Timesheet Tuesday record")
    private Day day3;

    @ApiModelProperty(notes = "Timesheet Wednesday record")
    private Day day4;

    @ApiModelProperty(notes = "Timesheet Thursday record")
    private Day day5;

    @ApiModelProperty(notes = "Timesheet Friday record")
    private Day day6;

    @ApiModelProperty(notes = "Timesheet Saturday record")
    private Day day7;

    @ApiModelProperty(notes = "Timesheet current PTOs")
    private List<PTO> ptos;
}
