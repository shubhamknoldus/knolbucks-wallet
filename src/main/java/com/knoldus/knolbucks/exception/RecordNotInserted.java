package com.knoldus.knolbucks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Record cannot be inserted")
public class RecordNotInserted extends RuntimeException{


    public RecordNotInserted() {
    }
}
