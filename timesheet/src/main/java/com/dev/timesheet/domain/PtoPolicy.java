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
@Document(collection = "PtoPolicy")
public class PtoPolicy {

    @Id
    @ApiModelProperty
    private String id;

    @ApiModelProperty(notes = "job title", required = true)
    private String jobtitle;

    @ApiModelProperty(notes = "ptopolicy year", required = true)
    private Integer year;

    @ApiModelProperty
    private Integer floatingnum;

//    @ApiModelProperty
//    private Integer holidayleft;

    @ApiModelProperty
    private Integer vacationnum;
}
