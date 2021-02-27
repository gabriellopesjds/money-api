package com.gabriellopesjds.moneyapi.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String code;
    private final Object[] args;

    public BusinessException(String code, String message, Object[] args) {
        this.code = code;
        this.args = args;
    }

    public BusinessException(String code) {
        this.code = code;
        args = null;
    }


}
