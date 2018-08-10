package com.sda.rebate;

import com.sda.model.Basket;
import com.sda.rebate.Rebate;
import org.springframework.stereotype.Service;

@Service
public class RebateTwo implements Rebate {

    @Override
    public double calculate(Basket basket) {
        System.out.println("poszedł rabat 'drugi' 0.2");
        return basket.getBasketPrice() * 0.2;
    }
}
