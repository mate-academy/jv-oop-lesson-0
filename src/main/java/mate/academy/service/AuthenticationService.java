package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService;

    public AuthenticationService() {
        this.userService = new UserService();
    }

    public boolean login(String email, String password) {
        if (userService == null) {
            throw new IllegalStateException("UserService is not properly initialized.");
        }
        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
