package com.thoughtworks.gtb.model;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class Education {

    private long userId;
    private long year;
    @Size(min = 1, max = 256, message = "invalid title")
    private String title;
    @Size(min = 1, max = 4096, message = "invalid description")
    private String description;
}
