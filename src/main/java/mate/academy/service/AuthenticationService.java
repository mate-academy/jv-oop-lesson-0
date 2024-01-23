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
        UserService userservice = new UserService();

        if (userservice.findByEmail(email) == null) {
            return false;
        } else if ((email == userservice.findByEmail(email).getEmail())
                && password == userservice.findByEmail(email).getPassword()) {
            return true;
        } else {
            return false;
        }

    }
}
