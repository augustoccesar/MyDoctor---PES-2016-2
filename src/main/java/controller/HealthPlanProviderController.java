package controller;

import configuration.JsonTransformer;
import dao.HealthPlanProviderDAOImpl;
import dao.interfaces.HealthPlanProviderDAO;

import static spark.Spark.get;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class HealthPlanProviderController {
    public HealthPlanProviderController(String baseUrl) {
        get(baseUrl, (req, res) -> {
            HealthPlanProviderDAO healthPlanProviderDAO = new HealthPlanProviderDAOImpl();
            return healthPlanProviderDAO.list();
        }, new JsonTransformer());

        get(baseUrl + "/:id", (req, res) -> {
            HealthPlanProviderDAO healthPlanProviderDAO = new HealthPlanProviderDAOImpl();
            return healthPlanProviderDAO.find(Integer.parseInt(req.params(":id")));
        }, new JsonTransformer());
    }
}
