package br.com.itauseguros.core.models;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -7702972179768502623L;
    private String id;
    private String name;
    private String category;
    private Double basePrice;
    private Double ratedPrice;

    public Product(String id, String name, String category, Double basePrice, Double ratedPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
        this.ratedPrice = ratedPrice;
    }
    public Product(String name, String category, Double basePrice) {
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getRatedPrice() {
        return ratedPrice;
    }

    public void setRatedPrice(Double ratedPrice) {
        this.ratedPrice = ratedPrice;
    }
}

