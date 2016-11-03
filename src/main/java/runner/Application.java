package runner;

import controller.ExpertiseController;
import controller.LoginController;
import controller.PointOfCareController;
import controller.UserController;

import static spark.Spark.before;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class Application {
    public static void main(String[] args) {
        before((req, res) -> {
            res.header("Content-Type", "application/json");
        });

        new LoginController("/auth");
        new UserController("/users");
        new PointOfCareController("/points-of-care");
        new ExpertiseController("/expertise");
    }
}
