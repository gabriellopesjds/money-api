package com.gabriellopesjds.moneyapi.launch.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.rest.dto.PageableDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
public class LaunchResponseDTO {

    private UUID id;
    private String description;
    private LocalDate expirationDate;
    private LocalDate paymentDate;
    private BigDecimal value;
    private String observation;
    private LaunchTypeEnum type;
    private CategoryResponseDTO category;
    private PersonResponseDTO person;

    @JsonProperty("pageable")
    @Setter
    private PageableDTO pageableDTO;

}
