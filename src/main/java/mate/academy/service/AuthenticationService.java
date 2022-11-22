package mate.academy.service;

public class AuthenticationService {
    public boolean login(String email, String password) {

        if (UserService.findByEmail(email) == null
                || !UserService.findByEmail(email)
                .getPassword().equals(password)) {
            return false;
        } else {
            return true;
        }
    }
}
