package mate.academy.service;

import mate.academy.model.User;

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
        for (int i = 0; i < 5; i++) {
            UserService test2 = new UserService();
            User test3 = test2.findByEmail(email);
            if (test3 != null && test3.getEmail().equals(email)
                    && test3.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
}
