package mate.academy.service;

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.User;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
        // Adding some sample users
        users.add(new User("bob@i.ua", "1234"));
        users.add(new User("alice@i.ua", "1234"));
        users.add(new User("john@i.ua", "password")); // Ensure this is the correct password for 'john'
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user; // User found
            }
        }
        return null; // User not found
    }
}
