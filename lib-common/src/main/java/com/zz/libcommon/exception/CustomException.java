package com.zz.libcommon.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private String message;

    public CustomException( String message) {
        this.message = message;
    }
}
