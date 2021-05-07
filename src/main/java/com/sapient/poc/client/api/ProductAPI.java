package com.sapient.poc.client.api;

import com.sapient.poc.dto.MyResponseBody;
import com.sapient.poc.entity.CategoryEntity;
import com.sapient.poc.entity.Product;
import com.sapient.poc.entity.ProductGroup;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductAPI {

    @GET("/products/products")
    public Call<List<Product>> allProducts();

    @POST("/products/product")
    Call<Product> createProducts(@Body Product product);

    @PUT("/products/product/{id}")
    Call<Product> updateProducts(@Path("id")Long id,@Body Product product);

    @GET("/products/groupByCategories")
    Call<MyResponseBody> getProductGroupByCategories();

    @DELETE("/products/products/{id}")
    Call<Long> deleteProduct(@Path("id")long id);

}
