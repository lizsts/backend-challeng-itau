package br.com.itauseguros.core.useCases;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.core.stategies.CategoryPriceCalculationStrategy;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductServiceGateway productServiceGateway;
    private final CategoryPriceCalculationStrategy categoryStrategy;

    @Override
    public void execute(Product product) {
       var newRatedPrice = categoryStrategy.calculatePrice(product);
        product.setRatedPrice(newRatedPrice);

        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        productServiceGateway.saveProduct(product);

    }
}
