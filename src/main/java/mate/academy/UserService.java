package mate.academy;

import mate.academy.model.User;

public class UserService {

    public User findByEmail(String email) {
        if ("bob@i.ua".equals(email)) {
            return new User("bob@i.ua", "1234");
        } else if ("alice@i.ua".equals(email)) {
            return new User("alice@i.ua", "1234");
        } else {
            return null;
        }
    }
}
