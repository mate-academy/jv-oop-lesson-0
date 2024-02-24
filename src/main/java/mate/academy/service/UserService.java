package mate.academy.service;

import mate.academy.model.User;

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
    public User findByEmail(String email) {
        int userNumber = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getEmail().equals(email)) {
                userNumber = i;
            }
        }
        if (userNumber == -1) {
            return null;
        } else {
            return users[userNumber];
        }
    }
}
