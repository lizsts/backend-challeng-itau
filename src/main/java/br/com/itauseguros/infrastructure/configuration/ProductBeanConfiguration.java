package br.com.itauseguros.infrastructure.configuration;

import br.com.itauseguros.application.ProductServiceGateway;
import br.com.itauseguros.infrastructure.presenters.ProductDTOConverter;
import br.com.itauseguros.infrastructure.presenters.ProductRepositoryConverter;
import br.com.itauseguros.infrastructure.persistence.repositories.ProductRepository;
import br.com.itauseguros.infrastructure.rest.ProductExistsValidator;
import br.com.itauseguros.infrastructure.rest.ProductServiceGatewayImpl;
import br.com.itauseguros.core.stategies.CategoryPriceCalculationStrategy;
import br.com.itauseguros.core.useCases.CreateProductUseCaseImpl;
import br.com.itauseguros.core.useCases.UpdateProductUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfiguration {

    @Autowired
    private ProductRepository productRepository;

    @Bean("createRepositoryConverter")
    public ProductRepositoryConverter createRepositoryConverter() {
        return new ProductRepositoryConverter();
    }
    @Bean("createDTOConverter")
    public ProductDTOConverter createDTOConverter() {
        return new ProductDTOConverter();
    }

    @Bean("createCategoryStrategy")
    public CategoryPriceCalculationStrategy createCategoryStrategy() {
        return new CategoryPriceCalculationStrategy();
    }

    @Bean("serviceGatewayImpl")
    public ProductServiceGatewayImpl serviceGatewayImpl() {
        return new ProductServiceGatewayImpl(productRepository, createRepositoryConverter());
    }
    @Bean("createProductUseCaseImpl")
    public CreateProductUseCaseImpl createProductUseCaseImpl(ProductServiceGateway serviceGateway) {
        return new CreateProductUseCaseImpl(serviceGateway, createCategoryStrategy());
    }

    @Bean("updateProductUseCaseImpl")
    public UpdateProductUseCaseImpl updateProductUseCaseImpl(ProductServiceGateway serviceGateway) {
        return new UpdateProductUseCaseImpl(serviceGateway, createCategoryStrategy());
    }

    @Bean("validatorHasProduct")
    public ProductExistsValidator validatorHasProduct(ProductServiceGateway serviceGateway) {
        return new ProductExistsValidator(serviceGateway);
    }

}
