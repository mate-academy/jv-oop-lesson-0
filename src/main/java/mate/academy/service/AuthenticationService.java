package mate.academy.service;

public class AuthenticationService {

    private UserService user = new UserService();

    public boolean login(String email, String password) {
        if ((user.findByEmail(email) != null && user.findByEmail(email).getPassword() == password)) {
            return true;
        }
        return false;
    }
}
