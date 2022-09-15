package mate.academy.service;

import mate.academy.model.User;
import mate.academy.service.UserService;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param password - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    public boolean login (String email, String password) {
        boolean result = false;
        for (User user : UserService.users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    result = true;
                }
            }
        }
        return result;
    }
}
