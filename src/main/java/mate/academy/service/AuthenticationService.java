package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class AuthenticationService {
    private static final UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        return user != null && Objects.equals(user.getPassword(), password);
    }
}
