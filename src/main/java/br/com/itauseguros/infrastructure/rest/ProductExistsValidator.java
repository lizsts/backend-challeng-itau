package br.com.itauseguros.infrastructure.rest;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.application.exceptions.InvalidProductNameException;
import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductExistsValidator {
    private final ProductServiceGateway productServiceGateway;

    @SneakyThrows
    public boolean validateHasProduct(Product product) {

        if (product.getName().isEmpty()) {
            throw new InvalidProductNameException("O nome do produto não pode estar vazio");
        }

        Optional<ProductEntity> persistedProduct = productServiceGateway.findProductByName(product.getName());
        return persistedProduct.isPresent();
    }
}

