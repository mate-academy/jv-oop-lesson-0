package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = new User(email, password);
        if (userService.findByEmail(email) != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
