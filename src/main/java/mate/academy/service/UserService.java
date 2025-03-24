package mate.academy.service;

import java.util.List;
import mate.academy.model.User;

public class UserService {
    private List<User> users;

    public UserService() {
        users = List.of(
                new User("bob@i.ua", "1234"),
                new User("alice@i.ua", "1234"),
                new User("john@i.ua", "5678")
        );
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
