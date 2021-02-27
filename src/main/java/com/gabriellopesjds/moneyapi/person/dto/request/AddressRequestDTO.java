package com.gabriellopesjds.moneyapi.person.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AddressRequestDTO {

    @NotNull
    private String publicPlace;

    @NotNull
    private String number;

    private String complement;

    @NotNull
    private String district;

    @NotNull
    private String cep;

    @NotNull
    private String city;

    @NotNull
    private String state;
}
