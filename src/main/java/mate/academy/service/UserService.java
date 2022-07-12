package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };
    
    public User findByEmail(String email) {
        for (User allUsers : users) {
            if (allUsers.getEmail().equals(email)) {
                return allUsers;
            }
        }
        return null;
    }
}
