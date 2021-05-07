package com.sapient.poc.client.service;

import com.sapient.poc.dto.MyResponseBody;
import com.sapient.poc.entity.CategoryEntity;
import com.sapient.poc.entity.Product;
import com.sapient.poc.entity.ProductGroup;

import java.util.List;

public interface ProductClientService {
    public List<Product> getAllProduct();
    Product createProducts(Product product);
    Product updateProducts(Product product);
    Long deleteProduct(long id);
    MyResponseBody getProductgroupByCategories();

}
