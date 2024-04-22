package br.com.itauseguros.infrastructure.rest;

import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import br.com.itauseguros.infrastructure.persistence.repositories.ProductRepository;
import br.com.itauseguros.infrastructure.presenters.ProductRepositoryConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceGatewayImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductRepositoryConverter entityMapper;

    @InjectMocks
    private ProductServiceGatewayImpl productServiceGateway;


    @Test
    public void testSaveProductNewProduct() {
        // Arrange
        Product product = new Product("Test Product", "VIDA", 100.0);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId("5986");
        when(productRepository.findByName("Test Product")).thenReturn(Optional.of(productEntity));

        // Act
        productServiceGateway.saveProduct(product);

        // Assert
        assertEquals("5986", product.getId());
        assertEquals("Test Product", product.getName());
    }

    @Test
    public void testSaveProductExistingProduct() {
        Product product = new Product("Test Product", "VIDA", 100.0);
        ProductEntity existingProductEntity = new ProductEntity();
        existingProductEntity.setId("5986");
        when(productRepository.findByName("Test Product")).thenReturn(Optional.of(existingProductEntity));

        productServiceGateway.saveProduct(product);

        assertEquals("5986", product.getId());
        assertEquals("Test Product", product.getName());
    }

}