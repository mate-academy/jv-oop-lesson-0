package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User foundUser = userService.findByEmail(email);
        if (foundUser == null) {
            return false;
        }
        return foundUser.getPassword().equals(password);
    }
}
