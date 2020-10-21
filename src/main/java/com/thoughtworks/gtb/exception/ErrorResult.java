package com.thoughtworks.gtb.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

    private String timeStamp;
    private Integer status;
    private String message;
    private String error;
}
