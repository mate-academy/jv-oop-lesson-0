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
        UserService userService = new UserService();
        if (email.isEmpty() || password.isEmpty() || userService.findByEmail(email) == null) {
            return false;
        }
        String userEmail = userService.findByEmail(email).getEmail();
        String userPassword = userService.findByEmail(email).getPassword();
        if (userEmail.equals(email) && userPassword.equals(password)){
            return true;
        }
        return false;
    }
}
