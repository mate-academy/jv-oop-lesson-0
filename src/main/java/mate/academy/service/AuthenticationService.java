package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User currentUser = userService.findByEmail(email);
        return currentUser != null && currentUser.getPassword().equals(password);
    }
}
