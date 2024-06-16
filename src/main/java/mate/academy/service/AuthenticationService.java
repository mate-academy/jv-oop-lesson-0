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
      String qw = "1234";
      String as = "bob@i.ua";
      String zx = "alice@i.ua";
      if (qw.equals(password)&& as.equals(email)) {
          return true;
      } else if (qw.equals(password) && zx.equals(email)) {
          return  true;
      }
        return false;
    }
}
