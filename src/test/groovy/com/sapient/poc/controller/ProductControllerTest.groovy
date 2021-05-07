package com.sapient.poc.controller

import com.sapient.poc.entity.BrandEntity
import com.sapient.poc.entity.CategoryEntity
import com.sapient.poc.entity.ColorEntity
import com.sapient.poc.entity.Product
import com.sapient.poc.entity.SellerEntity
import com.sapient.poc.exceptions.ProductNotFoundException
import com.sapient.poc.service.ProductServiceImpl
import org.springframework.http.HttpStatus
import spock.lang.Specification

class ProductControllerTest extends Specification{

    ProductServiceImpl productService = Mock()
    ProductController productController = new ProductController(productService: productService);

    def "get product list - happy Path"(){
            given:
            productService.getAllProduct() >> createListProductsResponse()
            when:
            def result = productController.getAllProducts()
            then:
            result.getStatusCode() == HttpStatus.OK
    }


    def "get product list - unHappyPath - empty list"(){
        given:
        productService.getAllProduct() >> new ArrayList<Product>()
        when:
        def result = productController.getAllProducts()
        then:
        result.getStatusCode() == HttpStatus.OK
    }


    def "PUT update product - HappyPath "(){
        given:
        Product product = Stub(Product.class)
        productService.updateProducts(_) >> product

        when:
        def result = productController.updateProduct(product.getId(),product)
        then:
        result.getStatusCode() == HttpStatus.OK
    }

    def "PUT update product - unHappyPath - Not Found"(){
        given:
        Product product = Stub(Product.class)
        productService.updateProducts(_) >> {throw ProductNotFoundException}

        when:
        def result = productController.updateProduct(product.getId(),product)
        then:
        result.getStatusCode() == HttpStatus.BAD_REQUEST
    }


    private static List<Product> createListProductsResponse() {
        ArrayList<Product> list = new ArrayList<>();
        CategoryEntity categoryEntity2 = new CategoryEntity("Socks");
        CategoryEntity categoryEntity3 = new CategoryEntity("Shirt");
        CategoryEntity categoryEntity4 = new CategoryEntity("Denim");

        BrandEntity brandEntity = new BrandEntity("Levis");
        BrandEntity brandEntity1 = new BrandEntity("UCB");
        BrandEntity brandEntity2 = new BrandEntity("CK");

        ColorEntity colorEntity2 = new ColorEntity("YELLOW");
        ColorEntity colorEntity3 = new ColorEntity("ORANGE");

        SellerEntity sellerEntity = new SellerEntity("JOHN & SONS");
        SellerEntity sellerEntity1 = new SellerEntity("ROHAN & SONS");
        SellerEntity sellerEntity2 = new SellerEntity("PETR & SONS");

        list.add(new Product("Shirt Blue","BLUE SHIRT WIT STIPE", BigDecimal.valueOf(12233.99),sellerEntity2,categoryEntity4,colorEntity3,brandEntity1));
        list.add(new Product("YELLOW Blue","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(123233.99),sellerEntity1,categoryEntity2,colorEntity2,brandEntity2));
        list.add(new Product("SOCKS","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(1233.99),sellerEntity,categoryEntity3,colorEntity2,brandEntity));

        return list;
    }

}
