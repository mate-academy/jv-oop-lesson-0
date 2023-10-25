package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     *  email - user's email
     *  password - user's password
     *  true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */

    public boolean login(String email, String password) {
        UserService us = new UserService();
        User user = us.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
