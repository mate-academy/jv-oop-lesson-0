package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User ourUser = userService.findByEmail(email);
        return ourUser != null && ourUser.getPassword().equals(password);
    }
}
