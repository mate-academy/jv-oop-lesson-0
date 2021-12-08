package mate.academy.service;

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
<<<<<<< HEAD
        if (UserService.findByEmail(email) != null
                && UserService.findByEmail(email).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
=======
        if (UserService.findByEmail(email) != null && UserService.findByEmail(email).getPassword().equals(password)) {
                return true;
        } else return false;
>>>>>>> 0dac24fdfa0a775c48ef4549ee59d00708748b5d
    }
}
