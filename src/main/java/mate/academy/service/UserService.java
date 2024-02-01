package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    public static User getUserByEmail(String email) {

        if ("bob@i.ua".equals(email)) {
            return new User("bob@i.ua", "1234");
        } else if ("alice@i.ua".equals(email)) {
            return new User("alice@i.ua", "1234");
        } else if ("john@i.ua".equals(email)) {
            return new User("john@i.ua", "qwerty");
        } else {
            return null;
        }
    }
}
