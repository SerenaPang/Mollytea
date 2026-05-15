package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.entity.Product;

public interface MenuService {

    Iterable<Product> getProducts();

    Product getProductById(Long productId);

}