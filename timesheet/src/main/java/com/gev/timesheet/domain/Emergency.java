package com.gev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
public class Emergency {

    @ApiModelProperty(notes = "Emergency firstname1")
    private String firstname1;

    @ApiModelProperty(notes = "Emergency lastname1")
    private String lastname1;

    @ApiModelProperty(notes = "Emergency phone1")
    private String phone1;

    @ApiModelProperty(notes = "Emergency firstname2")
    private String firstname2;

    @ApiModelProperty(notes = "Emergency lastname2")
    private String lastname2;

    @ApiModelProperty(notes = "Emergency phone2")
    private String phone2;
}
