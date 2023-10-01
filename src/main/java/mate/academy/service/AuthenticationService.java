package mate.academy.service;

public class AuthenticationService {
    /**
     * Imagine that some user wants to log in to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param inputtedPassword - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    private final UserService userService = new UserService();

    public boolean login(String email, String inputtedPassword) {
        if (userService.findByEmail(email) != null && inputtedPassword != null) {
            return inputtedPassword.equals(userService.findByEmail(email).getPassword());
        }
        return false;
    }
}
