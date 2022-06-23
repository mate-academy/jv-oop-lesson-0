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
        String user1email = "bob@i.ua";
        String passworduser1 = "1234";
        String user2email = "alice@i.ua";
        String passworduser2 = "1234";
        if (email.equals(user1email) && password.equals(passworduser1)
                || email.equals(user2email) && password.equals(passworduser2)) {
            return true;
        }
        return false;

    }
}
