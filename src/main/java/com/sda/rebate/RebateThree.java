package com.sda.rebate;

import com.sda.model.Basket;
import com.sda.rebate.Rebate;
import org.springframework.stereotype.Service;

/**
 * Created by Rafał on 05.08.2018.
 */
@Service
public class RebateThree implements Rebate {

    @Override
    public double calculate(Basket basket) {
        System.out.println("poszedł rabat 'trzeci' 0.3");
        return basket.getBasketPrice() * 0.3;
    }
}
