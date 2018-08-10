package com.sda;

import com.sda.model.Basket;
import com.sda.model.Product;
import com.sda.model.ProductItem;
import com.sda.model.User;
import com.sda.rebate.Rebate;
import com.sda.repository.ProductRepository;
import com.sda.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class BasketApp {

    private UserRepository userRepository;

    private ProductRepository productRepository;

    private RebateFactory rebateFactory;


    public void start() {
        List<User> userList = userRepository.getUserList();
        System.out.println("Welocme in our shop. Please select user from 1 to " + userList.size());
        Scanner in = new Scanner(System.in);

        int userChoice = in.nextInt();
        User user = userList.get(userChoice - 1);
        Basket basket = new Basket();
        List<Product> products = productRepository.getProducts();
        System.out.println("Here is our product list : ");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ".) " + products.get(i).toString());
        }
        Rebate rebateForUser = rebateFactory.getRebateForUser(user);
        boolean checkout = false;
        while (checkout == false) {
            System.out.println("\n\nWhat You would like to do : \nAdd product - press 1\nCheckout - press 2\nSee Your basket - press 3");
            int decision = in.nextInt();
            switch (decision) {
                case 1:
                    System.out.println("Enter product number");
                    int productNumber = in.nextInt();
                    Product product = products.get(productNumber - 1);
                    basket.addProduct(product);
                    break;

                case 2:
                    double sum = rebateForUser.calculate(basket);
                    System.out.println("Do zapłaty: " + sum + "\n");
                    checkout = true;
                    break;
                default:
                    System.out.println("basket");
                    List<ProductItem> basketProductItems = basket.getProductItems();
                    System.out.println(basketProductItems.toString());
                    System.out.println("Masz w koszyku:");
                    int i = 1;
                    for (ProductItem p : basketProductItems) {
                        System.out.println(i++ + ". " + p.getProduct().getName() + " w cenie " + p.getProduct().getPrice());
                    }
            }
        }
        System.out.println("Koniec transakcji\nuser " + user.getName() + " zamówił:");
        basket.printBasketProducts();
        double poRabacie = rebateForUser.calculate(basket);
        System.out.println("wartość koszyka =" + basket.getBasketPrice() + "\nwartość zamówienia po rabacie =" + poRabacie);

    }
}
