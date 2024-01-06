package mate.academy.service;

import java.util.Objects;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     *
     * @param email    - user's email
     * @param password - user's password
     */
    public boolean login(String email, String password) {
        UserService userService = new UserService();

        return Objects.requireNonNull(UserService.findByEmail(email)).getEmail().equals(email)
                && Objects.requireNonNull(UserService.findByEmail(email)).getPassword()
                .equals(password);
    }
}
