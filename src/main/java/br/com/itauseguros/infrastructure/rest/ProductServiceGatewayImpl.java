package br.com.itauseguros.infrastructure.rest;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.infrastructure.presenters.ProductRepositoryConverter;
import br.com.itauseguros.core.models.Product;
import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import br.com.itauseguros.infrastructure.persistence.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceGatewayImpl implements ProductServiceGateway {

    private final ProductRepository productRepository;
    private final ProductRepositoryConverter entityMapper;

    @Override
    @Transactional
    public void saveProduct(Product product) {
        Optional<ProductEntity> persistedProduct = productRepository.findByName(product.getName());

        if (persistedProduct.isPresent()) {
            product.setId(persistedProduct.get().getId());
            updateProduct(product);
        } else {
            var newProduct = entityMapper.toEntity(product);
            productRepository.save(newProduct);
            entityMapper.toModel(newProduct);
        }
    }

    @Transactional
    public String updateProduct(Product updatedProduct) {
        var persistedProduct = findProductByName(updatedProduct.getName());
        persistedProduct.setBasePrice(updatedProduct.getBasePrice());
        persistedProduct.setRatedPrice(updatedProduct.getRatedPrice());
        persistedProduct.setCategory(updatedProduct.getCategory());
        persistedProduct.setName(updatedProduct.getName());
        productRepository.save(persistedProduct);
        entityMapper.toModel(persistedProduct);

        return persistedProduct.getId();
    }

    @Override
    public ProductEntity findProductByName(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode estar vazio");
        }

        Optional<ProductEntity> optionalProductEntity = productRepository.findByName(productName);
        return optionalProductEntity.orElse(null);
    }

}

