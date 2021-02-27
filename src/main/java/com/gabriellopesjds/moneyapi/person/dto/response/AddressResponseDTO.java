package com.gabriellopesjds.moneyapi.person.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddressResponseDTO {

    private String publicPlace;
    private String number;
    private String city;
}
