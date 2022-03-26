package com.example.hiringagency.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class EntriesDetails implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Date" )
    private Date date;

    private String firstName;

    private String lastName;

    @Column(name = "Status" )
    private Long status;

    @JsonFormat(locale = "en",timezone = "GMT-5", pattern = "HH:mm")
    @Column(name = "StartTime" )
    private Timestamp startTime;

    //	@JsonFormat(timezone = "GMT-5", pattern = "yyyy:MM:dd HH:mm:ss.SSS")
    @JsonFormat(locale = "en", timezone = "GMT-5", pattern = "HH:mm")
    @Column(name = "EndTime" )
    private Timestamp endTime;

}
