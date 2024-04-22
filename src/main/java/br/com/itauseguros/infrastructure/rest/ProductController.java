package br.com.itauseguros.infrastructure.rest;

import br.com.itauseguros.infrastructure.presenters.ProductDTOConverter;
import br.com.itauseguros.infrastructure.rest.dto.ProductRequest;
import br.com.itauseguros.infrastructure.rest.dto.ProductResponse;
import br.com.itauseguros.core.useCases.CreateProductUseCase;
import br.com.itauseguros.core.useCases.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final ProductExistsValidator hasProductValidator;
    private final ProductDTOConverter dtoMapper;

    @PostMapping
    public ResponseEntity<ProductResponse> createOrUpdateProduct(@RequestBody ProductRequest product) {
        var newProduct = dtoMapper.toModel(product);
        if(hasProductValidator.validateHasProduct(newProduct)) {
          updateProductUseCase.execute(newProduct);
        log.info("Calling updateProductUseCase to update product: {}", newProduct.getName());

        } else {
            createProductUseCase.execute(newProduct);
            log.info("Calling createProductUseCase to create product: {}", newProduct.getName());
        }
        return new ResponseEntity<>(dtoMapper.toResponse(newProduct), HttpStatus.OK);
    }

}
