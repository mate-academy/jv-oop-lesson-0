package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private final UserService userService;

    public AuthenticationService() {
        this.userService = new UserService(new User[]{});
    }

    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String email, String password) {
        if (userService != null) {
            User foundUser = userService.findByEmail(email);
            return foundUser != null && foundUser.getPassword().equals(password);
        }
        return false;
    }
}
