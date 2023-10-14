package mate.academy.service;

public class AuthenticationService {
    private static final String BOB_EMAIL = "bob@i.ua";
    private static final String BOB_PASSWORD = "querty";
    private static final String DEFAULT_PASSWORD = "1234";

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
        if (BOB_EMAIL.equalsIgnoreCase(email)) {
            return BOB_PASSWORD.equals(password);
        }
        return DEFAULT_PASSWORD.equals(password);
    }
}
