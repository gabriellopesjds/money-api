package com.gabriellopesjds.moneyapi.launch.repository;

import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class FinderAllLaunchSpecificationParameters {
    private String description;
    private LocalDate expirationDateStart;
    private LocalDate expirationDateEnd;
    private LaunchTypeEnum type;
}
