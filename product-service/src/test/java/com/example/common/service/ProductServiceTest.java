package com.example.common.service;

import com.example.product.client.ProductFeignClient;
import com.example.product.domain.Product;
import com.example.common.domain.ProductTestData;
import com.example.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductFeignClient productFeignClient;

    @Autowired
    private ProductService productService;

    @Test
    public void getProductById_whenValidClientResponse_returnAllPosts() {
        when(productFeignClient.getProductById(anyString())).thenReturn(ProductTestData.product());

        Product product = productService.getProductById("BB5476");

        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo(1);
    }

}
