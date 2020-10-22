package com.sameer.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class SellerEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String accountId;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Product.class)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();


    public SellerEntity()
    {
    }

    public SellerEntity(String accountId)
    {
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}