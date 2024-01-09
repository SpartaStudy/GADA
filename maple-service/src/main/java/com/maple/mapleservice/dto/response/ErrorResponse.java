package com.maple.mapleservice.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
