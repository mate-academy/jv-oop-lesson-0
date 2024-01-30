package mate.academy.service;
import mate.academy.model.User;
public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     *
     * @param email    - user's email
     * @param password - user's password
     */
    public boolean login(String email, String password) {
        UserService userService = new UserService();
        if (userService.findByEmail(email) == null) {
            return false;
        }
        User user = userService.findByEmail(email);

            if (user != null && user.getPassword().equals(password) != false){
                return true;
            }else{
        return false;
    }
    }}
