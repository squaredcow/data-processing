package com.luxoft.it.emailservice.models;

import lombok.Data;

@Data
public class EmailDTO {
    private String from;
    private String to;
    private String subject;
    private String body;
}
