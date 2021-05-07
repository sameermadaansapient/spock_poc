package com.sapient.poc.service;

import com.sapient.poc.entity.CategoryEntity;
import com.sapient.poc.entity.Product;
import com.sapient.poc.entity.ProductGroup;

import java.util.List;

public interface ProductService {
    Product createProducts(Product product);
    Product updateProducts(Product product);
    List<Product> getAllProduct();
    Product getProductById(long productId);
    void deleteProduct(long id);
    List<CategoryEntity> getProductByCatId(Long id);
    List<ProductGroup> getProductgroupByCategories();

    List<ProductGroup> getProductgroupByBrands();

    List<ProductGroup> getProductgroupBySeller();

    Object getTotalBySeller(Long id);
}
