package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private static final UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        if (email == null || password == null) {
            return false;
        }
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
