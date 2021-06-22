package com.example.common.domain;

import com.example.product.domain.Product;

public class ProductTestData {

    public static Product product() {
        return new Product("", "", "title", null, "", null, true, null);
    }

}
