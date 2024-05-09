package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private static final UserService AUTHENTICATION_SERVICE = new UserService();
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param password - user's password
     *                 new User("bob@i.ua", "1234"),
     *             new User("alice@i.ua", "1234")
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */

    public boolean login(String email, String password) {
        User userFromDb = AUTHENTICATION_SERVICE.findByEmail(email);
        if (userFromDb == null) {
            return false;
        }
        return userFromDb.getPassword().equals(password);
    }
}
