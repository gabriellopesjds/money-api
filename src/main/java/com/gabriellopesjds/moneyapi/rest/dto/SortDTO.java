package com.gabriellopesjds.moneyapi.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortDTO {

    @JsonProperty("sorted")
    private Boolean sorted;

    @JsonProperty("unsorted")
    private Boolean unsorted;

    @JsonProperty("empty")
    private Boolean empty;

}
