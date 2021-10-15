package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public User findByEmail(String email) {
        for (User user : users) {
            if (email == user.getEmail()) {
                return user;
            }
        }
        return null;
    }

    public User findByPassword(String password) {
        for (User user : users) {
            if (password == user.getPassword()) {
                return user;
            }
        }
        return null;
    }
}
