package com.dev.timesheet.domain;

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
@Document
public class Timesheet {
    @Id
    @ApiModelProperty(notes = "The database generated customer ID")
    private String id;

    @ApiModelProperty(notes = "Timesheet first name", required = true)
    private String firstname;
    @ApiModelProperty(notes = "Timesheet last name")
    private String lastname;
}
