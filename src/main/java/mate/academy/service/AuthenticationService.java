package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = UserService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
