package dao;

import dao.interfaces.HealthPlanProviderDAO;
import database.DatabaseManager;
import exceptions.EntityNotPassedValidation;
import mappers.HealthPlaneProviderMapper;
import model.HealthPlanProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class HealthPlanProviderDAOImpl implements HealthPlanProviderDAO {
    @Override
    public HealthPlanProvider find(int id) {
        String sql = "" +
                "SELECT " +
                "   hpp.id AS hpp_id, hpp.name AS hpp_name " +
                "FROM health_plan_providers hpp " +
                "WHERE hpp.id = ?";

        HealthPlanProvider healthPlanProvider = null;

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                healthPlanProvider = HealthPlaneProviderMapper.readFromResultSet("hpp", rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthPlanProvider;
    }

    @Override
    public List<HealthPlanProvider> list() {
        String sql = "" +
                "SELECT " +
                "   hpp.id AS hpp_id, hpp.name AS hpp_name " +
                "FROM health_plan_providers hpp";

        List<HealthPlanProvider> healthPlanProviders = new ArrayList<>();

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HealthPlanProvider healthPlanProvider = HealthPlaneProviderMapper.readFromResultSet("hpp", rs);
                healthPlanProviders.add(healthPlanProvider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthPlanProviders;
    }

    @Override
    public HealthPlanProvider save(HealthPlanProvider healthPlanProvider) {
        if(!healthPlanProvider.isValid()) throw new EntityNotPassedValidation(healthPlanProvider);

        String sql = "INSERT INTO health_plan_providers (name) VALUES (?)";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, healthPlanProvider.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next()){
                healthPlanProvider.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthPlanProvider;
    }
}
