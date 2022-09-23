package mate.academy.service;

import mate.academy.model.User;

import java.util.Arrays;

public class AuthenticationService {
     /**
     * Imagine that some user wants to log in to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param password - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    public boolean login(String email, String password) {
        UserService userService = new UserService();

        if (userService.findByEmail(email) == null) {
            return false;
        }

        User currentUser = userService.findByEmail(email);
        return currentUser.getPassword().equals(password) ? true : false;
    }
}
