package com.sapient.poc.client.model;

import com.sapient.poc.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProductResponse {
    List<Product> products;
}
