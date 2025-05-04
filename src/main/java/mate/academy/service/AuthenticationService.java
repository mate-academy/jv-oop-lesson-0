package mate.academy.service;

public class AuthenticationService {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
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
        try {
            if (email.matches(EMAIL_REGEX) && !password.isEmpty()) {
                if (email.equals(new UserService().findByEmail(email).getEmail()) && password.equals(new UserService().findByEmail(email).getPassword()))
                    return true;
            } else return false;
        }catch (NullPointerException exception) {
            exception.getMessage();
        }
        return false;
    }
}
