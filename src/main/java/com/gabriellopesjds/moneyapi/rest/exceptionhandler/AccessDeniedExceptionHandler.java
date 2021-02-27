package com.gabriellopesjds.moneyapi.rest.exceptionhandler;

import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import com.gabriellopesjds.moneyapi.rest.dto.ErrorDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AccessDeniedExceptionHandler extends AbstractExceptionHandler<AccessDeniedException> {

    @Override
    public ResponseEntity<BaseResponse<Object>> handleException(AccessDeniedException exception) {
        ErrorDetailResponse detail = ErrorDetailResponse.builder()
            .message("Without authorization for access to resource. message: " + exception.getMessage())
            .build();

        List<ErrorDetailResponse> responseList = Collections.singletonList(detail);

        return handleErrorModelResponse(HttpStatus.FORBIDDEN, "Forbidden", responseList);
    }

}
