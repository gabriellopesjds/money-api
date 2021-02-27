package com.gabriellopesjds.moneyapi.rest.api;

import com.gabriellopesjds.moneyapi.category.application.service.CategoryApplicationService;
import com.gabriellopesjds.moneyapi.category.dto.request.CategoryRequestDTO;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryApplicationService categoryApplicationService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> saveCategory(@Valid @RequestBody CategoryRequestDTO requestDTO){
        CategoryResponseDTO responseDTO = categoryApplicationService.saveCategory(requestDTO);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDTO.getId())
            .toUri();

        return ResponseEntity.created(uri)
            .body(responseDTO);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<BaseResponse<List<CategoryResponseDTO>>> listCategory(@AuthenticationPrincipal UserDetails userDetails){
        List<CategoryResponseDTO> responseDTOList = categoryApplicationService.listCategories();
        return responseDTOList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(BaseResponse.withData(responseDTOList));
    }
}
