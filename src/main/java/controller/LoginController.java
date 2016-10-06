package controller;

import configuration.JsonTransformer;

import static spark.Spark.get;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class LoginController {
    public LoginController(String baseUrl) {
        get(baseUrl + "/login", (req, res) -> {
            // TODO implement
            return "/login endpoint";
        }, new JsonTransformer());

        get(baseUrl + "/register", (req, res) -> {
            // TODO implement
            return "/register endponit";
        }, new JsonTransformer());
    }
}
