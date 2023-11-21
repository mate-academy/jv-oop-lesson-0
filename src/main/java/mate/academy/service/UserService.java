package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        for (int i = 0; i < users.length; i++) {
            if (email.equals(users[i].getEmail())) {
                return users[i];
            }
        }
        return null;
    }

    public boolean findByPassword(String password, String userPassword) {
        if (password.equals(userPassword) && !password.equals(null)) {
            return true;
        }
        return false;
    }
}
