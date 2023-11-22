package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User x = userService.findByEmail(email);
        if (x == null) {
            return false;
        }
        return x.getPassword().equals(password);
    }
}
