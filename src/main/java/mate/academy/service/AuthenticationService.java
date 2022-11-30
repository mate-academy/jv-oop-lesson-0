package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private static final UserService users = new UserService();

    public boolean login(String email, String password) {
        User user = users.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
