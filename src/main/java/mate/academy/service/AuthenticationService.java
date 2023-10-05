package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User userLogin = userService.findByEmail(email);

        if (userLogin != null && password.equals(userLogin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
