package mate.academy.service;

import mate.academy.model.User;

import java.util.Arrays;
import java.util.Optional;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmailClassic(String email) {
        for (User user : users
        ) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public Optional<User> findByEmail(String email) {
        return Arrays.stream(users)
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

}
