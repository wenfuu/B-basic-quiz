package com.thoughtworks.gtb.model;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    @Size(min = 1, max = 128, message = "invalid name")
    private String name;
    //TODO GTB-知识点: - User.java:17 小细节需要注意，value=16，意味着可以取值16，但题目要求的是age>16
    @Min(value = 16, message = "invalid age.")
    private Long age;
    @Size(min=8, max = 512, message = "invalid avatar url")
    private String avatar;
    @Size(max = 1024, message = "invalid description")
    private String description;
    private List<Education> educations;
}
