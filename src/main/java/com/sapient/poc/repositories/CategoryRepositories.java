package com.sapient.poc.repositories;

import com.sapient.poc.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<CategoryEntity,Long> {
}
