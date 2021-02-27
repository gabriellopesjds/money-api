package com.gabriellopesjds.moneyapi.launch.domain.service;

import com.gabriellopesjds.moneyapi.launch.domain.model.Launch;
import com.gabriellopesjds.moneyapi.rest.dto.PageableDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageableFactory {

    public PageableDTO buildResponse(Pageable pageable, Page<Launch> launchPage) {
        return PageableDTO.builder()
            .pageNumber(pageable.getPageNumber())
            .pageSize(pageable.getPageSize())
            .offset(pageable.getOffset())
            .unpaged(pageable.isUnpaged())
            .paged(pageable.isPaged())
            .size(launchPage.getSize())
            .totalPages(launchPage.getTotalPages())
            .totalElements(launchPage.getTotalElements())
            .numberOfElements(launchPage.getNumberOfElements())
            .number(launchPage.getNumber())
            .last(launchPage.isLast())
            .first(launchPage.isFirst())
            .build();
    }

}
