package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[]{
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public static User[] getUsers() {
        return users;
    }

    public User findByEmail(String email) {
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i].getEmail().equals(email)) {
                return getUsers()[i];
            }
        }
        return null;
    }
}
