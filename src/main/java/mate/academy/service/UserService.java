package mate.academy.service;

import java.util.Arrays;
import java.util.Optional;
import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        Optional<User> first = Arrays.stream(users)
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        return first.orElse(null);
    }
}
