package com.sapient.poc.client;

import com.sapient.poc.client.service.ProductClientServiceImpl;
import com.sapient.poc.dto.MyResponseBody;
import com.sapient.poc.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ProductClientController {

    @Autowired
    ProductClientServiceImpl productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/groupByCategories")
    public ResponseEntity<MyResponseBody> getAllProductsGroupbyCat(){
        return ResponseEntity.ok().body(productService.getProductgroupByCategories());

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
