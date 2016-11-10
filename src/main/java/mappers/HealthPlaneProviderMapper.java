package mappers;

import mappers.interfaces.Mapper;
import model.HealthPlanProvider;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class HealthPlaneProviderMapper implements Mapper<HealthPlanProvider>{

    @Override
    public HealthPlanProvider readFromResultSet(String alias, ResultSet rs) throws SQLException {
        HealthPlanProvider healthPlanProvider = new HealthPlanProvider();

        healthPlanProvider.setId(rs.getInt(alias + "_id"));
        healthPlanProvider.setName(rs.getString(alias + "_name"));

        return healthPlanProvider;
    }
}
