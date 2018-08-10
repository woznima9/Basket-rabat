package com.sda.model;


import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

@Value
@EqualsAndHashCode
public class Product {

    private String name;

    private Integer price;

    @Override
    public String toString() {
        return "Product name : " + name + ", price : " + price;
    }
}
