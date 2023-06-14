package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param emailEntered - user's email
     * @param passwordEntered - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    public boolean login(String emailEntered, String passwordEntered) {
        UserService userService = new UserService();
        User findedUser = userService.findByEmail(emailEntered);
        if (findedUser == null) {
            return false;
        } else {
            return passwordEntered.equals(findedUser.getPassword());
        }
    }
}
