package br.com.itauseguros.integration;

import br.com.itauseguros.infrastructure.persistence.entities.ProductEntity;
import br.com.itauseguros.infrastructure.persistence.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:itausegdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=password",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class DbH2InterationTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testH2Connection() {
        ProductEntity entity = new ProductEntity();
        entity.setCategory("VIDA");
        entity.setName("Exemplo Vida");
        entity.setId(UUID.randomUUID().toString());

        productRepository.save(entity);
       ProductEntity persistedProduct = productRepository.findByName(entity.getName()).get();

        assertThat(persistedProduct).isNotNull();

    }
}
