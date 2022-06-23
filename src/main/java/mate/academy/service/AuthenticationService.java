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
        String user1_email = "bob@i.ua";
        String password_user1 = "1234";
        String user2_email = "alice@i.ua";
        String password_user2 = "1234";
        if (email.equals(user1_email) && password.equals(password_user1)) {
            return true;
        } else
            return email.equals(user2_email) && password.equals(password_user2);
    }
}
