package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    /**
     * Find user by email. All users are stored in <code>private static final User[] users</code>
     *
     * @param email - the input parameter
     * @return - user if his email is equal to passed email.
     * Return <code>null</code> if there is no suitable user
     */
    public boolean findByEmail(String email) {
        boolean equalEmail = false;
        for (int i = 0; i < 2; i++) {
            if (email.equals(users[i].getEmail())) {
                equalEmail = true;
            }
        }
        return equalEmail;
    }

    public boolean findByPassword(String password) {
        boolean equalPass = false;
        for (int i = 0; i < 2; i++) {
            if (password.equals(users[i].getPassword())) {
                equalPass = true;
            }
        }
        return equalPass;
    }
}
