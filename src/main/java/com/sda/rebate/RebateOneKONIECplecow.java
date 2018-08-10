package com.sda.rebate;

import com.sda.model.Basket;
import com.sda.rebate.Rebate;
import org.springframework.stereotype.Service;

@Service
public class RebateOneKONIECplecow implements Rebate {

    @Override
    public double calculate(Basket basket) {
        System.out.println("poszedł rabat 'pierwszy' 0.1");
        return basket.getBasketPrice() * 0.1;
    }
}
