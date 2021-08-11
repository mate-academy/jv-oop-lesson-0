package mate.academy.service;

import com.sun.source.tree.IfTree;

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
    public boolean login(String email, String password) {
        UserService check = new UserService();
        if (check.findByEmail(email) != null && check.findByEmail(email).getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
