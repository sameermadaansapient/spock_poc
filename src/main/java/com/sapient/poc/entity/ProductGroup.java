package com.sapient.poc.entity;

import java.util.List;

public class ProductGroup {
    String type;
    Long Id;
    String name;
    List<Product> products;

    public ProductGroup(String type, Long id, String name, List<Product> products) {
        this.type = type;
        Id = id;
        this.name = name;
        this.products = products;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
