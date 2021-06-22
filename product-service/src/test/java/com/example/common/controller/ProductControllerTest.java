package com.example.common.controller;

import com.example.common.domain.ProductTestData;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductById_whenValidRequest_returnsValidResponse() throws Exception {
        when(productService.getProductById(anyString())).thenReturn(ProductTestData.product());

        mockMvc.perform(get("/posts"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$[0].id", equalTo(1)))
            .andExpect(jsonPath("$[0].userId", equalTo(1)))
            .andExpect(jsonPath("$[0].title", equalTo("title")))
            .andExpect(jsonPath("$[0].body", equalTo("body")));
    }

    @Test
    public void createProduct_whenUnsupportedHttpVerb_returnsMethodNotAllowed() throws Exception {
        mockMvc.perform(post("/posts"))
            .andExpect(status().isMethodNotAllowed())
            .andExpect(jsonPath("$.message", equalTo("Method Not Allowed")))
            .andExpect(jsonPath("$.debugMessage", equalTo("Request method 'PATCH' not supported")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
