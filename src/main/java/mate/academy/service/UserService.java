package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public static User[] getUsers() {
        return users;
    }

    public User findByEmail(String email) {
        for (int i = 0; i < UserService.getUsers().length; i++) {
            if (UserService.getUsers()[i].getEmail().equals(email)) {
                return UserService.getUsers()[i];
            }
        }
        return null;
    }
}
