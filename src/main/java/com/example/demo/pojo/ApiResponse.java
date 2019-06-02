package com.example.demo.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse {
    private Integer code;
    private String status;
    private String message;
}
