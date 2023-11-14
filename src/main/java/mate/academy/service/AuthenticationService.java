package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    private static final UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        return user != null && user.getEmail().equals(email)
                && user.getPassword().equals(password);
    }
}
