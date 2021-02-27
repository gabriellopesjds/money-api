package com.gabriellopesjds.moneyapi.category.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CategoryResponseDTO {

    private UUID id;
    private String name;
}
