package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User checkEmail = userService.findByEmail(email);
        return checkEmail != null && checkEmail.getPassword().equals(password);
    }
}
