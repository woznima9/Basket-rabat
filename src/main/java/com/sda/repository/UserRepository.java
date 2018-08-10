package com.sda.repository;

import com.sda.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        User user1 = new User("Antek1", 60, "Katowice");
        User user2 = new User("Krzysztof2", 36, "Warszawa");
        User user3 = new User("Rafal3", 45, "Radom");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public List<User> getUserList() {
        return userList;
    }
}
