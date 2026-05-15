package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.entity.Product;
import com.mollytea.mollyteawebapp.repository.ProductRepository;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Component;

@Component
class JpaMenuService implements MenuService {

    private final ProductRepository productRepository;

    JpaMenuService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(this::mapEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long productId) {
        return this.productRepository.findById(productId)
                .map(this::mapEntity)
                .orElse(null);
    }

    Product mapEntity(Product product) {
        return new Product(product.getId(), product.getName(), product.getPrice(), product.getCategoryId());
    }
}
