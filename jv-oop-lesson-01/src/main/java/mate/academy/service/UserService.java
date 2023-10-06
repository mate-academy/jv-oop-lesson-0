package mate.academy.service;

import mate.academy.model.User;

public class UserService {
    public static final User[] users = new User[]{
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
    public String findByEmail(String email) {
        String a = null;
        for (int i = 0; i < users.length; i++)
            if (email.equals(users[i].getEmail())) {
                a = String.valueOf(users[i]);
            }
        return a;
    }
}
