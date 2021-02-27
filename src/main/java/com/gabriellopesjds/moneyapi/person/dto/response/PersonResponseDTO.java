package com.gabriellopesjds.moneyapi.person.dto.response;

import com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class PersonResponseDTO {

    private UUID id;

    private String name;

    private StatusEnum status;

    private List<AddressResponseDTO> addressList = new ArrayList<>();
}
