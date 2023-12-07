package mate.academy.service;

public class AuthenticationService {

    public boolean login(String email, String password) {
        UserService user = new UserService();
        if (user.findByEmail(email) != null) {
            return user.findByEmail(email).getPassword().equals(password);
        }
        return false;
    }
}
