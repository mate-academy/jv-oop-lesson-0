package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private final UserService userService = new UserService();

    public boolean login(String email, String password) {
        User testUser = userService.findByEmail(email);
        if (testUser != null) {
            return testUser.getPassword().equals(password);
        }
        return false;
    }

    public UserService getUserService() {
        return userService;
    }
}
