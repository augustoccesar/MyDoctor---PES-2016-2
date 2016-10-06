package controller;

import configuration.JsonTransformer;

import static spark.Spark.put;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class UserController {
    public UserController(String baseUrl) {
        put(baseUrl + "/self", (req, res) -> {
            // TODO implement
            return "/self update (PUT) endpoint";
        }, new JsonTransformer());
    }
}
