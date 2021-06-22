package com.example.product.service;

import com.example.product.client.ProductFeignClient;
import com.example.product.client.ReviewFeignClient;
import com.example.product.domain.Product;
import com.example.product.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductFeignClient productFeignClient;
    private final ReviewFeignClient reviewFeignClient;

    @Override
    public Product getProductById(String productId) {
        Product product = productFeignClient.getProductById(productId);
        Review review = reviewFeignClient.getReviewByProduct(productId);
        product.setReview(review);
        return product;
    }
}
