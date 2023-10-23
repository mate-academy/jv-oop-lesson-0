package mate.academy.service;

public class AuthenticationService {
    public boolean login(String email, String password) {
        return new UserService().findByEmail(email) != null
                && new UserService().findByEmail(email).getPassword().equals(password);
    }
}
