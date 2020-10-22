package com.sameer.test.service;

import com.sameer.test.entity.*;
import com.sameer.test.exceptions.ProductNotFoundException;
import com.sameer.test.repositories.BrandRepository;
import com.sameer.test.repositories.CategoryRepositories;
import com.sameer.test.repositories.ProductRepository;
import com.sameer.test.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepositories categoryRepositories;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Product createProducts(Product product) {

        CategoryEntity categoryEntity = product.getFallIntoCategories();
        System.out.println(categoryEntity.getId() + " " + categoryEntity.getName());

        System.out.println(categoryRepositories.findAll());
        CategoryEntity cat = new CategoryEntity(categoryEntity.getName());
        product.setFallIntoCategories(categoryRepositories.save(cat));

        return productRepository.save(product);
    }

    @Override
    public Product updateProducts(Product product) {
        Optional<Product> productDb = productRepository.findById(product.getId());
        if(productDb.isPresent()){
            Product product1 = productDb.get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setId(product.getId());
            product1.setDescription(product.getDescription());
            productRepository.save(product1);
            return product1;
        }else{
            throw new ProductNotFoundException("Product Not Found");
        }

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        if(productDb.isPresent()){
            return productDb.get();
        }else{
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> productDb = productRepository.findById(id);
        if(productDb.isPresent()){
            productRepository.deleteById(id);
        }else{
            throw new ProductNotFoundException("Product Not Found");
        }
    }

    @Override
    public List<CategoryEntity> getProductByCatId(Long id) {
        return categoryRepositories.findAll();
    }

    @Override
    public List<ProductGroup> getProductgroupByCategories() {
        List<ProductGroup> products = new ArrayList<>();
        List<CategoryEntity> categoryEntities = categoryRepositories.findAll();
        categoryEntities.forEach(categoryEntity -> {
            List<Product> list = productRepository.findAllByCatId(categoryEntity);
            if(list.size()>0){
                products.add(new ProductGroup("categories",categoryEntity.getId(),categoryEntity.getName(),list));
            }
        });

        return products;
    }

    @Override
    public List<ProductGroup> getProductgroupByBrands() {
        List<ProductGroup> products = new ArrayList<>();
        List<BrandEntity> brandEntities = brandRepository.findAll();
        brandEntities.forEach(brandEntity -> {
            List<Product> list = productRepository.findAllByBrand(brandEntity);
            if(list.size()>0){
                products.add(new ProductGroup("Brands",brandEntity.getId(),brandEntity.getName(),list));
            }
        });

        return products;
    }

    @Override
    public List<ProductGroup> getProductgroupBySeller() {
        List<ProductGroup> products = new ArrayList<>();
        List<SellerEntity> sellerEntities = sellerRepository.findAll();
        sellerEntities.forEach(sellerEntity -> {
            List<Product> list = productRepository.findAllBySeller(sellerEntity);
            if(list.size()>0){
                products.add(new ProductGroup("Seller",sellerEntity.getId(),sellerEntity.getAccountId(),list));
            }
        });

        return products;
    }

    @Override
    public Integer getTotalBySeller(Long id) {
        SellerEntity sellerEntity = sellerRepository.getOne(id);
        return productRepository.findCountBySeller(sellerEntity);
    }
}
