package com.gabriellopesjds.moneyapi.rest.exceptionhandler;

import com.gabriellopesjds.moneyapi.exception.BusinessException;
import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApiExceptionHandler {

    private final BusinessExceptionHandler businessExceptionHandler;
    private final HttpMessageNotReadableExceptionHandler httpMessageNotReadableExceptionHandler;
    private final MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;
    private final AccessDeniedExceptionHandler accessDeniedExceptionHandler;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseResponse<Object>> handleHttpMessageNotReadable(HttpMessageNotReadableException exception){
        return httpMessageNotReadableExceptionHandler.handleException(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        return methodArgumentNotValidExceptionHandler.handleException(exception);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<Object>> handleBusinessException(BusinessException exception){
        return businessExceptionHandler.handleException(exception);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<Object>> handleAccessDeniedException(AccessDeniedException exception){
        return accessDeniedExceptionHandler.handleException(exception);
    }

}
