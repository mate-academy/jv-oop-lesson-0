package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return false;
        }
        return (Objects.equals(user.getPassword(), password));
    }
}

