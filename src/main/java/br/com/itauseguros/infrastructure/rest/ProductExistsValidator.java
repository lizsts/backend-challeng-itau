package br.com.itauseguros.infrastructure.rest;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;

import br.com.itauseguros.core.models.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductExistsValidator {
    private final ProductServiceGateway productServiceGateway;

    public boolean validateHasProduct(Product product) {
        if (product.getName().isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode estar vazio");
        }

        ProductEntity persistedProduct = productServiceGateway.findProductByName(product.getName());
        return persistedProduct != null;
    }
}

