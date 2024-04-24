package br.com.itauseguros.core.useCases;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.core.stategies.CategoryPriceCalculationStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductServiceGateway productServiceGateway;
    private final CategoryPriceCalculationStrategy categoryStrategy;

    @Override
    public void execute(Product product) {
        var newRatedPrice = categoryStrategy.calculatePrice(product);
        product.setRatedPrice(newRatedPrice);
        var productId = productServiceGateway.updateProduct(product);
        product.setId(productId);
    }

}
