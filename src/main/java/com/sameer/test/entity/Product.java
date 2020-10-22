package com.sameer.test.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updateAt;


    @ManyToOne(targetEntity = SellerEntity.class)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
     private SellerEntity seller;

    @ManyToOne(targetEntity = CategoryEntity.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity fallIntoCategories;

    @ManyToOne(targetEntity = ColorEntity.class)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private ColorEntity color;

    @ManyToOne(targetEntity = BrandEntity.class)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brand;

    public Product(String name, String description, BigDecimal price, SellerEntity seller, CategoryEntity fallIntoCategories, ColorEntity color, BrandEntity brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.fallIntoCategories = fallIntoCategories;
        this.color = color;
        this.brand = brand;
    }

    public Product() {
    }

    public SellerEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerEntity seller) {
        this.seller = seller;
    }

    public CategoryEntity getFallIntoCategories() {
        return fallIntoCategories;
    }

    public void setFallIntoCategories(CategoryEntity fallIntoCategories) {
        this.fallIntoCategories = fallIntoCategories;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
