package br.com.itauseguros.core.stategies;

import br.com.itauseguros.application.constants.CategoryConstants;
import br.com.itauseguros.application.exceptions.InvalidCategoryException;
import br.com.itauseguros.core.models.Product;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
public class CategoryPriceCalculationStrategy implements PriceCalculationStrategy {

    @Override
    public Double calculatePrice(Product product) {
        var category = product.getCategory().toUpperCase();
        validadeCategory(category);
        var basePrice = product.getBasePrice();
        var taxes = getCategoryTaxes(category);

        var iof = taxes.get("IOF");
        var pis = taxes.get("PIS");
        var cofins = taxes.get("COFINS");

        return basePrice * (1 + iof + pis + cofins);
    }

    @SneakyThrows
    @Override
    public void validadeCategory(String category) {
        if (!CategoryConstants.CATEGORY.contains(category)) {
            throw new InvalidCategoryException("Categoria inválida: " + category);
        }
    }

    public Map<String, Double> getCategoryTaxes(String category) {
        return CategoryConstants.CATEGORY_TAXES.getOrDefault(category, Collections.emptyMap());
    }

}
