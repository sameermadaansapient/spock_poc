package com.sameer.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "color")
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL , fetch = FetchType.LAZY ,targetEntity = Product.class)
            @JsonIgnore
    Set<Product> products = new HashSet<>();

    public ColorEntity() {
    }

    public ColorEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
