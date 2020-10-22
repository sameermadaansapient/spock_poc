package com.sameer.test.repositories;

import com.sameer.test.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity,Long> {
}
