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
@Document

public class Employee {
    @Id
    @ApiModelProperty(notes = "The database generated customer ID")
    private String id;

    @ApiModelProperty(notes = "Employee userid")
    private String userid;

    @ApiModelProperty(notes = "Employee phone")
    private String phone;

    @ApiModelProperty(notes = "Employee email")
    private String email;

    @ApiModelProperty(notes = "Employee address")
    private Address address;

    @ApiModelProperty(notes = "Employee emergency")
    private Emergency emergency;


}
