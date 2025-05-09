package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private final UserService userService;

    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public AuthenticationService() {
        this.userService = new UserService();
    }

    public boolean login(String email, String password) {
        if (email == null) {
            return false;
        }

        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
