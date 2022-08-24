package com.applaudo.andres.userManagementApp.controller.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyMMdd hh:mm:ss")
    private LocalDateTime time;
    private String message;

    public ErrorResponse(HttpStatus status){
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(){
        time = LocalDateTime.now();
    }


}
