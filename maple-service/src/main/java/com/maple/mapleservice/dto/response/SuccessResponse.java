package com.maple.mapleservice.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SuccessResponse {

    private LocalDateTime timestamp;
    private Object data; // dto 삽입

    public static SuccessResponse of(Object data){
        return SuccessResponse.builder()
                .timestamp(LocalDateTime.now())
                .data(data)
                .build();
    }
}