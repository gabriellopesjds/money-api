package com.gabriellopesjds.moneyapi.category.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CategoryRequestDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

}
