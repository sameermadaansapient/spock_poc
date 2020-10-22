package com.sameer.test.repositories;

import com.sameer.test.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<CategoryEntity,Long> {
}
