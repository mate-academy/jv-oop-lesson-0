package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService userChecking = new UserService();
        if (userChecking.findByEmail(email) != null
                && userChecking.findByEmail(email).getPassword() == password) {
            return true;
        }
        return false;
    }
}
