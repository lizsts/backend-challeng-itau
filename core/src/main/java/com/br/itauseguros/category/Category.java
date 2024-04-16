package com.br.itauseguros.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 5925218338126698589L;

    private Long id;
    private String name;
    private Double iof;
    private Double pis;
    private Double cofins;
}
