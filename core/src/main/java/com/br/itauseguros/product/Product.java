package com.br.itauseguros.product;

import com.br.itauseguros.category.Category;
import com.br.itauseguros.category.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 2095521265629673482L;

    private Long id;
    private String name;
    private CategoryEnum category;
    private Double basePrice;
    private Double ratedPrice;

}
