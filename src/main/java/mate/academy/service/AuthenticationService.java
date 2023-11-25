package mate.academy.service;

import java.util.Optional;
import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        Optional<User> byEmail = userService.findByEmail(email);
        Optional<User> byPassword = userService.findByPassword(password);
        if (byEmail.isEmpty() || byPassword.isEmpty()) {
            return false;
        }
        return email.equals(byEmail.get().getEmail())
                && password.equals(byPassword.get().getPassword());
    }
}
