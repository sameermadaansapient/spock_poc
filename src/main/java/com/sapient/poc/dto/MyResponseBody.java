package com.sapient.poc.dto;

import com.sapient.poc.entity.ProductGroup;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class MyResponseBody {
    Integer statusCode;
    String status;
    List<ProductGroup> result;

    public MyResponseBody(Integer statusCode, String status, List<ProductGroup> response) {
        this.statusCode = statusCode;
        this.status = status;
        this.result = response;
    }


}
