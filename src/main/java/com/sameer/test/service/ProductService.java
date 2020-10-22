package com.sameer.test.service;

import com.sameer.test.entity.CategoryEntity;
import com.sameer.test.entity.Product;
import com.sameer.test.entity.ProductGroup;

import java.util.List;
import java.util.Map;

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
