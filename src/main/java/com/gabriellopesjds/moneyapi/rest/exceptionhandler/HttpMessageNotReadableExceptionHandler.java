package com.gabriellopesjds.moneyapi.rest.exceptionhandler;

import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import com.gabriellopesjds.moneyapi.rest.dto.ErrorDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class HttpMessageNotReadableExceptionHandler extends AbstractExceptionHandler<HttpMessageNotReadableException>{

    @Override
    public ResponseEntity<BaseResponse<Object>> handleException(HttpMessageNotReadableException exception) {
        ErrorDetailResponse detail = ErrorDetailResponse.builder()
            .message("invalid body")
            .build();

        List<ErrorDetailResponse> responseList = Collections.singletonList(detail);

        return handleErrorModelResponse(HttpStatus.BAD_REQUEST, "Message Not Readable", responseList);
    }

}
