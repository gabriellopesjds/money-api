package com.gabriellopesjds.moneyapi.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PageableDTO {

    @JsonProperty("pageNumber")
    private Integer pageNumber;

    @JsonProperty("pageSize")
    private Integer pageSize;

    @JsonProperty("offset")
    private Long offset;

    @JsonProperty("unpaged")
    private Boolean unpaged;

    @JsonProperty("paged")
    private Boolean paged;

    @JsonProperty("totalPages")
    private Integer totalPages;

    @JsonProperty("totalElements")
    private Long totalElements;

    @JsonProperty("last")
    private Boolean last;

    @JsonProperty("first")
    private Boolean first;

    @JsonProperty("sort")
    private SortDTO sort;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("numberOfElements")
    private Integer numberOfElements;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("empty")
    private Boolean empty;

}
