package mate.academy.service;

import java.util.Objects;

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
        UserService base = new UserService();
        for (int i = 0; i < base.getSize(); i++) {
            if (Objects.equals(email, base.getMail(i))) {
                if (Objects.equals(password, base.getPass(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
