package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    /**
     * Imagine that some user wants to login to your site.
     @@ -10,7 +12,10 @@ public class AuthenticationService {
      * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    private UserService userService = new UserService();
    public boolean login(String email, String password) {
        return false;
        User user = userService.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}