package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService = new UserService();
    /**
     * Authenticates a user by email and password.
     *
     * @param email the user's email address
     * @param password the user's password
     * @return true if a user with the given email exists and the password matches,
     *         false otherwise
     */

    public boolean login(String email, String password) {
        User foundUser = userService.findByEmail(email);
        return foundUser != null && password.equals(foundUser.getPassword());
    }
}
