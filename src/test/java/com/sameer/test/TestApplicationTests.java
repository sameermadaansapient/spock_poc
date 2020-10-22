package com.sameer.test;

import com.sameer.test.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class TestApplicationTests {

    @Autowired
    private ProductController productController;


    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
    }

    @Test
    void getProductTest(){

    }

}
