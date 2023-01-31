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
        int i = 0;
        for (;i < users.length;i++) {
            if (email.trim().equals(users[i].getEmail().trim())) {
                break;
            }
        }
        return i == users.length ? null : users[i];
    }
}
