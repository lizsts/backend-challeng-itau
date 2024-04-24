package br.com.itauseguros.infrastructure.presenters;

import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.infrastructure.rest.dto.ProductRequest;
import br.com.itauseguros.infrastructure.rest.dto.ProductResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDTOConverter {

    public ProductResponse toResponse(Product enterpriseObj) {
        return new ProductResponse(enterpriseObj.getId(),
                enterpriseObj.getName(),
                enterpriseObj.getCategory(),
                enterpriseObj.getBasePrice(),
                enterpriseObj.getRatedPrice());
    }
    public Product toModel(ProductRequest requestObj) {
        return new Product(requestObj.getName(),
                requestObj.getCategory(),
                requestObj.getBasePrice());
    }

}
