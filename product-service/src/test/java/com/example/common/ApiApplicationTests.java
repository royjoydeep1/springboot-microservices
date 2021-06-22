package com.example.common;

import com.example.product.controller.ProductController;
import com.example.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
        assertThat(productService).isNotNull();
    }

}
