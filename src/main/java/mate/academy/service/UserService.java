package mate.academy.service;

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.User;

public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User("bob@i.ua", "1234"));
        users.add(new User("alice@i.ua", "1234"));
        users.add(new User("john@i.ua", "wrongpassword"));
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
