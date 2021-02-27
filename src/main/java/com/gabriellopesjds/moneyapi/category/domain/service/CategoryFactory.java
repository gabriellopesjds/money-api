package com.gabriellopesjds.moneyapi.category.domain.service;

import com.gabriellopesjds.moneyapi.category.domain.model.Category;
import com.gabriellopesjds.moneyapi.category.dto.request.CategoryRequestDTO;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory {

    public Category fromValue(CategoryRequestDTO requestDTO){
        Category category = new Category();
        category.setName(requestDTO.getName());
        return category;
    }

    public CategoryResponseDTO buildResponse(Category category){
        return CategoryResponseDTO.builder()
            .id(category.getId())
            .name(category.getName())
            .build();
    }

}
