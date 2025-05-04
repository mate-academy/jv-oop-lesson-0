package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private static UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return password.equals(user.getPassword());
        }
        return false;
    }
}
