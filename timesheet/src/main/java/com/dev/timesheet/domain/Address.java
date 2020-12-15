package com.dev.timesheet.domain;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity

public class Address {

    @ApiModelProperty(notes = "Address line1")
    private String line1;

    @ApiModelProperty(notes = "Address line2")
    private String line2;

    @ApiModelProperty(notes = "Address city")
    private String city;

    @ApiModelProperty(notes = "Address state")
    private String state;

    @ApiModelProperty(notes = "Address zipcode")
    private String zipcode;
}
