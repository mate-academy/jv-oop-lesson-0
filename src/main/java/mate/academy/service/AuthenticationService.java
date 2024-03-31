package mate.academy.service;

import mate.academy.model.User;

public class AuthenticationService {
    private UserService userService;

    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Imagine that some user wants to login to your site.
     * You should check if user credentials (login and password) are valid or not.
     * All users are stored in <code>UserService</code> class.
     * @param email - user's email
     * @param password - user's password
     * @return true if user by email exists and passed password is equal to user's password.
     * Return false in any other cases.
     */
    public boolean login(String email, String password) {
        // Отримуємо користувача за email з сервісу користувачів
        User user = userService.findByEmail(email);

        // Перевіряємо, чи користувач знайдений та чи вірний його пароль
        if (user != null && user.getPassword().equals(password)) {
            return true; // Вхід успішний
        }

        return false; // Вхід неуспішний
    }
}
