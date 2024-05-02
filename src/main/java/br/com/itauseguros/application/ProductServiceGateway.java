package br.com.itauseguros.application;

import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import br.com.itauseguros.core.models.Product;

import java.util.Optional;

public interface ProductServiceGateway {
     void saveProduct(Product product);
     String updateProduct(Product updatedProduct);
     Optional<ProductEntity> findProductByName(String productName);


}
