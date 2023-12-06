package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        mate.academy.service.UserService userService = new UserService();
        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}