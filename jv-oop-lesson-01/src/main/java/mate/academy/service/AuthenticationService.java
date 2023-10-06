package mate.academy.service;

import mate.academy.Main;
import mate.academy.model.User;




public class AuthenticationService  {
    public static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };
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
        boolean a = true;
        for (int i = 0; i < users.length; i++) {
            if (email.equals(users[i].getEmail()) && password.equals(users[i].getPassword())) {
                a = true;
            }
            else a = false;
        }
        return a;
    }
}
