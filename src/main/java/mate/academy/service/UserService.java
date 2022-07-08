
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
    public boolean findByEmail(String email, String password) {
        boolean check = false;
        for (int i = 0; i < users.length;i++) {
            if ((users[i].getEmail().equals(email)) && (users[i].getPassword().equals(password))) {
                check = true;
            }
        }
        return check;
    }
}
