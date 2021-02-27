package com.gabriellopesjds.moneyapi.category.domain.service;

import com.gabriellopesjds.moneyapi.category.domain.model.Category;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import com.gabriellopesjds.moneyapi.category.persistence.repository.CategoryRepository;
import com.gabriellopesjds.moneyapi.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetterCategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryFactory categoryFactory;

    public List<CategoryResponseDTO> listCategories() {
        return categoryRepository.findAll().stream()
            .map(categoryFactory::buildResponse)
            .collect(Collectors.toList());
    }

    public Category findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new BusinessException("MONEY-002"));
    }

}
