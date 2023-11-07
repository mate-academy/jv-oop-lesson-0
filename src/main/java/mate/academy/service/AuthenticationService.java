package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService;

    public AuthenticationService() {
        this.userService = new UserService();
    }

    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String email, String password) {
        User user = userService.findByEmail(email);

        if (userService != null) {
            User foundUser = userService.findByEmail(email);
            return user != null && user.getPassword().equals(password);
        }
        return false;
    }
}
