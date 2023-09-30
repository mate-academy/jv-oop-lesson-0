package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        for (User user : users) {
            if (Objects.equals(email, user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}
