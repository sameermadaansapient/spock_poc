package com.sapient.poc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "fallIntoCategories", cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Product.class)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();



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

    public CategoryEntity()
    {
    }

    public CategoryEntity(String name)
    {
        this.name = name;
    }

    // getters and setters omitted
}