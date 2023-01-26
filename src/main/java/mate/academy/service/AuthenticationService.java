package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        if (new UserService().findByEmail(email) == null) {
            return false;
        }
        return new UserService().findByEmail(email).getPassword().equals(password);
    }
}
