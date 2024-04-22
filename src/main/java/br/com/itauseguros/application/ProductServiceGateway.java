package br.com.itauseguros.application;

import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import br.com.itauseguros.core.models.Product;

public interface ProductServiceGateway {
     void saveProduct(Product product);
     String updateProduct(Product updatedProduct);
     ProductEntity findProductByName(String productName);


}
