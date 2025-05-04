package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();

    public boolean login(String email, String password) {
        User userFromUserService = userService.findByEmail(email);
        return (userFromUserService != null
                    && userFromUserService.getPassword().equals(password));
    }
}
