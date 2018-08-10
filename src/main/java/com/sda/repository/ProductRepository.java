package com.sda.repository;

import com.sda.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    private static List<Product> products;

    static {
        products = new ArrayList<Product>();
        Product p1 = new Product("Komputer", 1000);
        Product p2 = new Product("Klawiatura", 100);
        Product p3 = new Product("TV", 500);
        Product p4 = new Product("Myszka", 50);
        Product p5 = new Product("PS4", 2000);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
    }

    public List<Product> getProducts() {
        return products;
    }
}
