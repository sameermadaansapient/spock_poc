package com.sameer.test.dto;

import com.sameer.test.entity.ProductGroup;

import java.util.List;

public class MyResponseBody {
    Integer statusCode;
    String status;
    List<ProductGroup> result;

    public MyResponseBody(Integer statusCode, String status, List<ProductGroup> response) {
        this.statusCode = statusCode;
        this.status = status;
        this.result = response;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public List<ProductGroup> getResponse() {
        return result;
    }
}
