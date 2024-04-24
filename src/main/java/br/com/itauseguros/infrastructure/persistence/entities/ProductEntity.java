package br.com.itauseguros.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    @NotNull(message = "O campo nome não pode ser nulo")
    private String name;
    @NotEmpty
    private String category;
    @NotNull
    private Double basePrice;
    private Double ratedPrice;
}
