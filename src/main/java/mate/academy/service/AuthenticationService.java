package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    private UserService userService = new UserService();

    public boolean login(String email, String password) {

        User userLogin = userService.findByEmail(email);
        return userLogin != null && password.equals(userLogin.getPassword());
    }
}
