package com.sameer.test.controller;

import com.sameer.test.dto.MyResponseBody;
import com.sameer.test.entity.CategoryEntity;
import com.sameer.test.entity.Product;
import com.sameer.test.entity.ProductGroup;
import com.sameer.test.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }


    @GetMapping("/groupByCategories")
    public ResponseEntity<MyResponseBody> getAllProductsGroupbyCat(){
        return ResponseEntity.ok().body(new MyResponseBody(HttpStatus.OK.value(),"SUCCESS",productService.getProductgroupByCategories()));

    }

    @GetMapping("/groupByBrands")
    public ResponseEntity<MyResponseBody> getAllProductsGroupbyBrand(){
        return ResponseEntity.ok().body(new MyResponseBody(HttpStatus.OK.value(),"SUCCESS",productService.getProductgroupByBrands()));
    }

    @GetMapping("/groupBySeller")
    public ResponseEntity<MyResponseBody> getAllProductsGroupbySeller(){
        return ResponseEntity.ok().body(new MyResponseBody(HttpStatus.OK.value(),"SUCCESS",productService.getProductgroupBySeller()));
    }

    @GetMapping("/countBySeller/{id}")
    public ResponseEntity<Integer> getAllCountBySeller(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getTotalBySeller(id));
    }


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
       return ResponseEntity.ok().body(productService.createProducts(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody  Product product){
        product.setId(id);
        return ResponseEntity.ok().body(productService.updateProducts(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }

}
