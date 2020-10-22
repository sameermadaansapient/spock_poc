package com.sameer.test.repositories;

import com.sameer.test.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ColorRepository extends JpaRepository<ColorEntity,Long> {
}
