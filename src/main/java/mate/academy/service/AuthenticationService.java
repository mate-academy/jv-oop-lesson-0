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

        for (int i = 0; i < UserService.users.length; i++) {
            if (UserService.users[i].getEmail().equals(email)) {
                if (UserService.users[i].getPassword().equals(password)) {
                    return true;
                }

            }
        }

        return false;
    }
}
