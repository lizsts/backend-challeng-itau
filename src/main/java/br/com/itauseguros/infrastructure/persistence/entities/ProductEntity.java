package br.com.itauseguros.infrastructure.persistence.entities;

import jakarta.persistence.*;
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
    private String name;
    private String category;
    private Double basePrice;
    private Double ratedPrice;
}
