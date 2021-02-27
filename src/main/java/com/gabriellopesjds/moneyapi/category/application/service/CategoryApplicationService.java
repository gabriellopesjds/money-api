package com.gabriellopesjds.moneyapi.category.application.service;

import com.gabriellopesjds.moneyapi.category.domain.service.GetterCategoryService;
import com.gabriellopesjds.moneyapi.category.domain.service.RegisterCategoryService;
import com.gabriellopesjds.moneyapi.category.dto.request.CategoryRequestDTO;
import com.gabriellopesjds.moneyapi.category.dto.response.CategoryResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryApplicationService {

    private final RegisterCategoryService registerCategoryService;
    private final GetterCategoryService getterCategoryService;

    public CategoryResponseDTO saveCategory(CategoryRequestDTO requestDTO){
        return registerCategoryService.saveCategory(requestDTO);
    }

    public List<CategoryResponseDTO> listCategories() {
        return getterCategoryService.listCategories();
    }

}
