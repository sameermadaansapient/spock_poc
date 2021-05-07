package com.sapient.poc.client.service;

import com.sapient.poc.client.api.ApiAdapter;
import com.sapient.poc.client.api.ProductAPI;
import com.sapient.poc.dto.MyResponseBody;
import com.sapient.poc.entity.Product;
import com.sapient.poc.entity.ProductGroup;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class ProductClientServiceImpl implements ProductClientService{
    @Override
    public List<Product> getAllProduct() {
        ProductAPI productAPI = ApiAdapter.createService(ProductAPI.class);
        Call<List<Product>> callSync = productAPI.allProducts();
        try {
            Response<List<Product>> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Product createProducts(Product product) {
        ProductAPI productAPI = ApiAdapter.createService(ProductAPI.class);
        Call<Product> callSync = productAPI.createProducts(product);
        try {
            Response<Product> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Product updateProducts(Product product) {
        ProductAPI productAPI = ApiAdapter.createService(ProductAPI.class);
        Call<Product> callSync = productAPI.updateProducts(product.getId(),product);
        try {
            Response<Product> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Long deleteProduct(long id) {
        ProductAPI productAPI = ApiAdapter.createService(ProductAPI.class);
        Call<Long> callSync = productAPI.deleteProduct(id);
        try {
            Response<Long> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public MyResponseBody getProductgroupByCategories() {
        ProductAPI productAPI = ApiAdapter.createService(ProductAPI.class);
        Call<MyResponseBody> callSync = productAPI.getProductGroupByCategories();
        try {
            Response<MyResponseBody> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
