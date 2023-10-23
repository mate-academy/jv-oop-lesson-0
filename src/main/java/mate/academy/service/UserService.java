package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public String findByEmail(String email, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getEmail() == email && users[i].getPassword() == password) {
                return email;
            }
        }
        return null;
    }
}
