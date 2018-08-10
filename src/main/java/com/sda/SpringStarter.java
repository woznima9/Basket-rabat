package com.sda;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarter {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BasketApp basketApp = ctx.getBean(BasketApp.class);
        basketApp.start();
    }
}
