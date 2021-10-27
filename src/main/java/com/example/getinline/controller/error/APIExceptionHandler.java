package com.example.getinline.controller.error;

import com.example.getinline.constant.ErrorCode;
import com.example.getinline.dto.ApiErrorResponse;
import com.example.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> general(GeneralException e) {

        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(false, errorCode, errorCode.getMessage(e)));
    }


    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> exception(Exception e) {

        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(false, errorCode, errorCode.getMessage(e)));
    }

}
