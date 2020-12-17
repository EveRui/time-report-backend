package com.gev.timesheet.domain;

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
@Document(collection = "File")
public class File {

    @Id
    @ApiModelProperty(notes = "Database generated file ID")
    private String id;

    @ApiModelProperty(notes = "Employee userid")
    private String userid;

    @ApiModelProperty(notes = "file name")
    private String name;

    @ApiModelProperty(notes = "file path")
    private String path;

    @ApiModelProperty(notes = "upload date")
    private String date;
}
