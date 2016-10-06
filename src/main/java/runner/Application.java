package runner;

import controller.LoginController;
import controller.UserController;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class Application {
    public static void main(String[] args) {
        new LoginController("/auth");
        new UserController("/users");
    }
}
