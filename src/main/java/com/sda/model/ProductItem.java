package com.sda.model;

import com.sda.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductItem {

    private Product product;

    private Integer amount;

    public void increase() {
        amount = amount + 1;
    }
}
