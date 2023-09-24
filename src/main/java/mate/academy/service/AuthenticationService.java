package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private final UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
