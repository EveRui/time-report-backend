package com.dev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document(collection = "Pto")
public class PTO {
//    String tmp;
    @Id
    @ApiModelProperty(notes = "Database generated pto ID")
    private String id;

    @ApiModelProperty(notes = "Employee userid", required = true)
    private String userid;

    @ApiModelProperty(notes = "pto year", required = true)
    private Integer year;

    @ApiModelProperty(notes = "floating day left")
    private Integer floatingleft;

//    @ApiModelProperty(notes = "holiday day left")
//    private Integer holidayleft;

    @ApiModelProperty(notes = "vacation day left")
    private Integer vacationleft;
}
