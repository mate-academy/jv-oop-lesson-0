package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return false;
        }
        return user.getEmail().equals(email)
                && user.getPassword().equals(password);
    }
}
