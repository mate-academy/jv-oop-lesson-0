package mate.academy.service;

import java.util.Arrays;
import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        return Arrays.stream(users)
                .filter(user -> user.getEmail()
                        .equals(email)).findFirst()
                .orElse(null);
    }
}
