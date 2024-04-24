package br.com.itauseguros.infrastructure.presenters;

import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;

public class ProductRepositoryConverter {

    public ProductEntity toEntity(Product enterpriseObj) {
        return new ProductEntity(enterpriseObj.getId(),
                enterpriseObj.getName(),
                enterpriseObj.getCategory(),
                enterpriseObj.getBasePrice(),
                enterpriseObj.getRatedPrice());
    }

    public Product toModel(ProductEntity persistenceObj) {
        return new Product(persistenceObj.getId(),
                persistenceObj.getName(),
                persistenceObj.getCategory(),
                persistenceObj.getBasePrice(),
                persistenceObj.getRatedPrice());
    }
}
