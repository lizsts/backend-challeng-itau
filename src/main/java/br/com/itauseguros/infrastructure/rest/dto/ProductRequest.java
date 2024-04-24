package br.com.itauseguros.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = 2894154789356535922L;

    private String name;
    private String category;
    private Double basePrice;


}
