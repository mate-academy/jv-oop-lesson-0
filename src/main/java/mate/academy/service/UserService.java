package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public int getSize() {
        return users.length;
    }

    public String getMail(int index) {
        return users[index].getEmail();
    }

    public String getPass(int index) {
        return users[index].getPassword();
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
