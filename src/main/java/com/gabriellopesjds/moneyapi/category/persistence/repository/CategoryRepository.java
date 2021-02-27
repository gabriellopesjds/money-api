package com.gabriellopesjds.moneyapi.category.persistence.repository;

import com.gabriellopesjds.moneyapi.category.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
