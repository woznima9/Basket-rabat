package com.sda;


import com.sda.model.User;
import com.sda.rebate.Rebate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class RebateFactory {

    Map<String, Rebate> rebateMap;

    public Rebate getRebateForUser(User user) {
        if (user.getAge() > 50)
            return rebateMap.get("rebateOneKONIECplecow");
        else if (user.getAge() > 30 && user.getCity().equals("Radom"))
            return rebateMap.get("rebateTwo");
        else
            return rebateMap.get("rebateThree");
    }
}
