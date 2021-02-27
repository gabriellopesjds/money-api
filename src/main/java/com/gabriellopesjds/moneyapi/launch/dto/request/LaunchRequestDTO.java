package com.gabriellopesjds.moneyapi.launch.dto.request;

import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
public class LaunchRequestDTO {

    private String description;
    private LocalDate expirationDate;
    private LocalDate paymentDate;
    private BigDecimal value;
    private String observation;
    private LaunchTypeEnum type;
    private UUID categoryId;
    private UUID personId;

}
