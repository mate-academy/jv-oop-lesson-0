package mate.academy.service;

public class AuthenticationService {
    public boolean login(String email, String password) {
        UserService user = new UserService();
        return user.findByEmail(email).getPassword().equals(password);
    }

}
