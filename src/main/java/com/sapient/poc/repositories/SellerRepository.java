package com.sapient.poc.repositories;

import com.sapient.poc.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity,Long> {
}
