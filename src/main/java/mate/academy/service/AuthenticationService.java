package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
