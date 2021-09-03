package mate.academy.service;

import mate.academy.model.User;

import java.util.Arrays;


public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public static User findByEmail(String email) {
        User user = Arrays.stream(users).filter(findUser -> findUser.getEmail().equals(email)).findFirst().orElse(null);
        return user != null ? user : new User("none", "none");
    }
}
