package com.gabriellopesjds.moneyapi.launch.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriellopesjds.moneyapi.rest.dto.PageableDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class LaunchResponseWrapperDTO {

    @JsonProperty("data")
    List<LaunchResponseDTO> data;

    @JsonProperty("pageable")
    @Setter
    private PageableDTO pageableDTO;

}
