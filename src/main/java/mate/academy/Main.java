package mate.academy;
import mate.academy.model.User;
import mate.academy.service.AuthenticationService;
import mate.academy.service.UserService;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final AuthenticationService authenticationService;

    static {
        List<User> users = Arrays.asList(
                new User("bob@i.ua", "1234"),
                new User("alice@i.ua", "1234"),
                new User("john@i.ua", "4321")
        );
        UserService userService = new UserService(users);
        authenticationService = new AuthenticationService(userService);
    }
    public static void main(String[] args) {
        test("bob@i.ua", "1234", true);
        test("alice@i.ua", "1234", true);
        test("john@i.ua", "1234", false);
        test("bob@i.ua", "qwerty", false);
    }

    private static void test(String email, String password, boolean expected) {
        boolean actual = authenticationService.login(email, password);
        if (expected == actual) {
            System.out.println("Test passed for email: " + email + " and password " + password);
        } else {
            System.out.print("Expected to receive " + expected + ", but was " + actual + ". ");
            System.out.println("Email: " + email + ", password " + password);
        }
    }
}
