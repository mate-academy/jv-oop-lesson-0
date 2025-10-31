package mate.academy.service;

import mate.academy.model.User;

/**
 * Provides user authentication functionality.
 * Checks whether a user's email and password match
 * an existing record from the {@link UserService}.
 */
public class AuthenticationService {
    private final UserService userService = new UserService();

    /**
     * Validates user credentials.
     *
     * @param email    user's email
     * @param password user's password
     * @return true if a user with this email exists and the provided password matches;
     * false otherwise
     */
    public boolean login(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        User validUser = userService.findByEmail(email);

        return validUser != null && password.equals(validUser.getPassword());
    }
}
