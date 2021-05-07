package com.sapient.poc.repositories;

import com.sapient.poc.entity.BrandEntity;
import com.sapient.poc.entity.CategoryEntity;
import com.sapient.poc.entity.Product;
import com.sapient.poc.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select p from Product p where p.fallIntoCategories = :id")
    List<Product> findAllByCatId(@Param("id") CategoryEntity id);

    @Query(value = "select p from Product p where p.seller = :id")
    List<Product> findAllBySeller(@Param("id") SellerEntity id);

    @Query(value = "select p from Product p where p.brand = :id")
    List<Product> findAllByBrand(@Param("id") BrandEntity id);

    @Query(value = "select count (p) from Product p where p.seller = :id")
    Integer findCountBySeller(@Param("id") SellerEntity id);

}
