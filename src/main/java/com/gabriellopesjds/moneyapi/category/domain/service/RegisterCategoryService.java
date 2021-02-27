package com.gabriellopesjds.moneyapi.category.domain.service;

import com.gabriellopesjds.moneyapi.category.domain.model.Category;
import com.gabriellopesjds.moneyapi.category.dto.request.CategoryRequestDTO;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import com.gabriellopesjds.moneyapi.category.persistence.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterCategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryFactory categoryFactory;

    @Transactional
    public CategoryResponseDTO saveCategory(CategoryRequestDTO requestDTO){
        Category category = categoryFactory.fromValue(requestDTO);
        Category categorySaved = categoryRepository.saveAndFlush(category);
        return categoryFactory.buildResponse(categorySaved);
    }

}
