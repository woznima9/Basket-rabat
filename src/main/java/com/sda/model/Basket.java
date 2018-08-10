package com.sda.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Basket {

    private List<ProductItem> productItems;

    public Basket() {
        productItems = new ArrayList<ProductItem>();
    }

    public Integer getBasketPrice() {
        Integer basketPrice = 0;
        for (ProductItem pi : productItems) {
            basketPrice = basketPrice + pi.getProduct().getPrice() * pi.getAmount();
        }
        return basketPrice;
    }

    public void addProduct(Product product) {
        boolean productExists = false;
        for (ProductItem p : productItems) {
            if (p.equals(product)) {
                p.increase();
                productExists = true;
            }
        }
        if (productExists == false) {
            ProductItem pi = new ProductItem(product, 1);
            productItems.add(pi);
        }

    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void printBasketProducts() {
        int i = 1;

        for (ProductItem p : productItems) {
            System.out.println(i++ + ". " + p.getProduct().getName() + " w cenie " + p.getProduct().getPrice());
        }
    }
}
