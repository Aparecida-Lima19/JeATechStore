package com.jatechstore.jatechestore.dto;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.sql.Insert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

public class CustomError {

    private Instant timestap;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timestap, Integer status, String error, String path) {
        this.timestap = timestap;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestap() {
        return timestap;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

}
