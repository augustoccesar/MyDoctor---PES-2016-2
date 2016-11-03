package controller;

import configuration.JsonTransformer;
import dao.PointOfCareDAOImpl;
import dao.interfaces.PointOfCareDAO;

import static spark.Spark.get;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCareController {
    public PointOfCareController(String baseUrl) {
        get(baseUrl, (req, res) -> {
            PointOfCareDAO pointOfCareDAO = new PointOfCareDAOImpl();
            return pointOfCareDAO.list();
        }, new JsonTransformer());

        get(baseUrl + "/:id", (req, res) -> {
            PointOfCareDAO pointOfCareDAO = new PointOfCareDAOImpl();
            return pointOfCareDAO.find(Integer.parseInt(req.params(":id")));
        }, new JsonTransformer());
    }
}
