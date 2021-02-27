package com.gabriellopesjds.moneyapi.rest.exceptionhandler;

import com.gabriellopesjds.moneyapi.exception.BusinessException;
import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import com.gabriellopesjds.moneyapi.rest.dto.ErrorDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BusinessExceptionHandler extends AbstractExceptionHandler<BusinessException> {

    private final MessageSource messageSource;

    @Override
    public ResponseEntity<BaseResponse<Object>> handleException(BusinessException exception) {
        ErrorDetailResponse errorDetailResponse = ErrorDetailResponse.builder()
            .code(exception.getCode())
            .message(messageSource.getMessage(exception.getCode(), null, LocaleContextHolder.getLocale()))
            .build();
        return handleErrorModelResponse(HttpStatus.BAD_REQUEST, "Business Exception Error", Arrays.asList(errorDetailResponse));
    }

}
