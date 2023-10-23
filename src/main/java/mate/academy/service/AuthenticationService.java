package mate.academy.service;

import java.util.Objects;
import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User currentUser = userService.findByEmail(email);
        if (Objects.isNull(currentUser)) {
            return false;
        }
        return currentUser.getPassword().equals(password);
    }
}
