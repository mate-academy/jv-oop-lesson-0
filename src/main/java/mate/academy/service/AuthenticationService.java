package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        User userLog = userService.findByEmail(email);
        return userService.findByEmail(email) != null && userLog.getPassword().equals(password);
    }

}
