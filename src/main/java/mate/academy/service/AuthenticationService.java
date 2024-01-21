package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userService = new UserService();
        // Find the user by email
        User user = userService.findByEmail(email);

        // Check if the user exists and the provided password matches the user's password
        return user != null && user.getPassword().equals(password);
    }
}
