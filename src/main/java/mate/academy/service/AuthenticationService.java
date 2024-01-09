package mate.academy.service;

public class AuthenticationService {
    private static final UserService userService = new UserService();

    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     */
    public boolean login(String email, String password) {

        if (userService.findByEmail(email).getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}


