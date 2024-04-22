package br.com.itauseguros.core.stategies;

import br.com.itauseguros.application.exceptions.InvalidCategoryException;
import br.com.itauseguros.core.models.Product;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryPriceCalculationStrategyTest {

    @Test
    void calculatePriceValidCategory() {
        CategoryPriceCalculationStrategy strategy = new CategoryPriceCalculationStrategy();
        Product product = new Product("Product", "AUTO", 100.0);

        double calculatedPrice = strategy.calculatePrice(product);

        assertEquals(110.5, calculatedPrice); // Assuming IOF=0.055, PIS=0.04, COFINS=0.01
    }

    @Test
    void calculatePriceInvalidCategory() {
        CategoryPriceCalculationStrategy strategy = new CategoryPriceCalculationStrategy();
        Product product = new Product("Product", "INVALID_CATEGORY", 100.0);

        assertThrows(InvalidCategoryException.class, () -> strategy.calculatePrice(product));
    }

    @Test
    void getCategoryTaxesValidCategory() {
        CategoryPriceCalculationStrategy strategy = new CategoryPriceCalculationStrategy();
        String category = "AUTO";

        Map<String, Double> taxes = strategy.getCategoryTaxes(category);

        assertEquals(0.055, taxes.get("IOF"));
        assertEquals(0.04, taxes.get("PIS"));
        assertEquals(0.01, taxes.get("COFINS"));
    }

    @Test
    void getCategoryTaxesInvalidCategory() {
        // Arrange
        CategoryPriceCalculationStrategy strategy = new CategoryPriceCalculationStrategy();
        String category = "INVALID_CATEGORY";

        Map<String, Double> taxes = strategy.getCategoryTaxes(category);

        assertTrue(taxes.isEmpty());
    }
}