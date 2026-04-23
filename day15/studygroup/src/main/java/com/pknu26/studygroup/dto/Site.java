package com.pknu26.studygroup.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter  
public class Site {

    private Long id;
    private String contentKey;
    private String contentBody;
    private Date createdAt;
}
