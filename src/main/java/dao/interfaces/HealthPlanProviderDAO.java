package dao.interfaces;

import model.HealthPlanProvider;

import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public interface HealthPlanProviderDAO {
    HealthPlanProvider find(int id);
    List<HealthPlanProvider> list();
    HealthPlanProvider save(HealthPlanProvider healthPlanProvider);
}
