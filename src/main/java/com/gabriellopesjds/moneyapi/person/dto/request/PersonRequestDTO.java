package com.gabriellopesjds.moneyapi.person.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class PersonRequestDTO {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotEmpty
    @JsonProperty("adresses")
    private List<AddressRequestDTO> addressList = new ArrayList<>();
}
