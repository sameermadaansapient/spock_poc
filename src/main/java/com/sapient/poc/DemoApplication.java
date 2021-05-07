package com.sapient.poc;

import com.sapient.poc.entity.*;
import com.sapient.poc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    CategoryRepositories categoryRepositories;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity("Jacket");
        CategoryEntity categoryEntity2 = new CategoryEntity("Socks");
        CategoryEntity categoryEntity3 = new CategoryEntity("Shirt");
        CategoryEntity categoryEntity4 = new CategoryEntity("Denim");
        CategoryEntity categoryEntity5 = new CategoryEntity("TeeShirt");

        categoryEntity = categoryRepositories.save(categoryEntity);
        categoryEntity2 = categoryRepositories.save(categoryEntity2);
        categoryEntity3 = categoryRepositories.save(categoryEntity3);
        categoryEntity4 = categoryRepositories.save(categoryEntity4);
        categoryEntity5 = categoryRepositories.save(categoryEntity5);

        BrandEntity brandEntity = new BrandEntity("Levis");
        BrandEntity brandEntity1 = new BrandEntity("UCB");
        BrandEntity brandEntity2 = new BrandEntity("CK");

        brandEntity = brandRepository.save(brandEntity);
        brandEntity1 = brandRepository.save(brandEntity1);
        brandEntity2 = brandRepository.save(brandEntity2);


        ColorEntity colorEntity = new ColorEntity("RED");
        colorEntity = colorRepository.save(colorEntity);
        ColorEntity colorEntity2 = new ColorEntity("YELLOW");
        colorEntity2 = colorRepository.save(colorEntity2);
        ColorEntity colorEntity3 = new ColorEntity("ORANGE");
        colorEntity3 = colorRepository.save(colorEntity3);
        ColorEntity colorEntity4 = new ColorEntity("GREEN");
        colorEntity4 = colorRepository.save(colorEntity4);

        SellerEntity sellerEntity = new SellerEntity("JOHN & SONS");
        sellerEntity = sellerRepository.save(sellerEntity);

        SellerEntity sellerEntity1 = new SellerEntity("ROHAN & SONS");
        sellerEntity1 = sellerRepository.save(sellerEntity);

        SellerEntity sellerEntity2 = new SellerEntity("PETR & SONS");
        sellerEntity2 = sellerRepository.save(sellerEntity);

        productRepository.save(new Product("Shirt Blue","BLUE SHIRT WIT STIPE", BigDecimal.valueOf(12233.99),sellerEntity2,categoryEntity4,colorEntity3,brandEntity1));
        productRepository.save(new Product("YELLOW Blue","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(123233.99),sellerEntity1,categoryEntity2,colorEntity2,brandEntity2));
        productRepository.save(new Product("SOCKS","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(1233.99),sellerEntity,categoryEntity3,colorEntity2,brandEntity));
        productRepository.save(new Product("DENIM","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(11233.99),sellerEntity,categoryEntity4,colorEntity,brandEntity2));
        productRepository.save(new Product("Shirt DENIM","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(16233.99),sellerEntity2,categoryEntity4,colorEntity2,brandEntity2));
        productRepository.save(new Product("DENIM JACKER","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(33.99),sellerEntity1,categoryEntity4,colorEntity2,brandEntity2));
        productRepository.save(new Product("Shirt RED","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(133.99),sellerEntity,categoryEntity4,colorEntity2,brandEntity2));
        productRepository.save(new Product("Socks Blue","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(233.99),sellerEntity2,categoryEntity2,colorEntity,brandEntity1));
        productRepository.save(new Product("Shirt SOMETHING","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(933.99),sellerEntity1,categoryEntity3,colorEntity3,brandEntity2));
        productRepository.save(new Product("JACKER Blue","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(633.99),sellerEntity2,categoryEntity2,colorEntity3,brandEntity1));




    }
}
