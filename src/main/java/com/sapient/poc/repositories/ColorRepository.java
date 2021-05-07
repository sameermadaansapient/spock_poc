package com.sapient.poc.repositories;

import com.sapient.poc.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ColorRepository extends JpaRepository<ColorEntity,Long> {
}
