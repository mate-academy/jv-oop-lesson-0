package mate.academy.service;

public class UserService {
    private static final User[] users = new User[] {
            new User("bob@i.ua", "1234"),
            new User("alice@i.ua", "1234")
    };

    public static class User {
        private final String email;
        private final String password;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }

    /**
     * Знайти користувача за email. Усі користувачі зберігаються в <code>private static final User[] users</code>.
     * @param email - вхідний параметр
     * @return - користувач, якщо його email рівний переданому email.
     * Повертає <code>null</code>, якщо немає відповідного користувача.
     */
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}