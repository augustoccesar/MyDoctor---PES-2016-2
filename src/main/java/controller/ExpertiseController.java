package controller;

import configuration.JsonTransformer;
import dao.ExpertiseDAOImpl;
import dao.interfaces.ExpertiseDAO;

import static spark.Spark.get;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class ExpertiseController {
    public ExpertiseController(String baseUrl) {
        get(baseUrl + "/:id", (req, res) -> {
            ExpertiseDAO expertiseDAO = new ExpertiseDAOImpl();
            return expertiseDAO.find(Integer.parseInt(req.params(":id")));
        }, new JsonTransformer());

        get(baseUrl, (req, res) -> {
            ExpertiseDAO expertiseDAO = new ExpertiseDAOImpl();
            return expertiseDAO.list();
        }, new JsonTransformer());
    }
}
