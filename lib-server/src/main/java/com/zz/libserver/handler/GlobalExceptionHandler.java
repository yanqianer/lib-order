package com.zz.libserver.handler;

import com.zz.libcommon.exception.CustomException;
import com.zz.libcommon.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public Result handleException(CustomException e){

        return Result.error(e.getMessage());
    }


}
