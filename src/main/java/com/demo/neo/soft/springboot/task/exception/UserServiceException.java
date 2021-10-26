package com.demo.neo.soft.springboot.task.exception;

import lombok.Getter;

@Getter
public class UserServiceException extends RuntimeException {

    private final InternalStandardError error;

    public UserServiceException(InternalStandardError error) {
        this.error = error;
    }
}