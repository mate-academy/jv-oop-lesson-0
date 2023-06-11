package mate.academy.service;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     *
     * @param email - user's email
     * @param password - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    //The variable is responsible for managing the database
    private static final UserService userService = new UserService();

    public boolean login(String email, String password) {
        //Save the result of authentication
        boolean permission = false;

        //Check if the passed data exists in the database
        if (userService.findByEmail(email) != null) {
            permission = userService.findByEmail(email).getPassword().equals(password);
        }

        return permission;
    }
}
