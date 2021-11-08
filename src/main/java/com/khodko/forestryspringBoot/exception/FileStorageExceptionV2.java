package com.khodko.forestryspringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class FileStorageExceptionV2 extends ResponseStatusException {

    private String traceId;

    public FileStorageExceptionV2(String message) {
        super(HttpStatus.BAD_REQUEST, message);
        this.traceId = UUID.randomUUID().toString();
    }

    public FileStorageExceptionV2(String message, Throwable cause) {
        super(HttpStatus.BAD_REQUEST,message, cause);
        this.traceId = UUID.randomUUID().toString();
    }
}
