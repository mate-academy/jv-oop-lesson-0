package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private User user;

    public boolean login(String email, String password) {
        UserService userService = new UserService();

        this.user = userService.findByEmail(email);

        return this.user != null && this.user.getPassword().equals(password);
    }
}
