package br.com.itauseguros.core.stategies;

import br.com.itauseguros.core.models.Product;

import java.util.Map;

public interface PriceCalculationStrategy {
    Double calculatePrice(Product product);

    void validadeCategory(String category);

    Map<String, Double> getCategoryTaxes(String category);

}
