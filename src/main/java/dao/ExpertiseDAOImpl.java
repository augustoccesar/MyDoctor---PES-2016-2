package dao;

import dao.interfaces.ExpertiseDAO;
import database.DatabaseManager;
import exceptions.EntityNotPassedValidation;
import mappers.ExpertiseMapper;
import model.Expertise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class ExpertiseDAOImpl implements ExpertiseDAO {
    @Override
    public Expertise find(int id) {
        String sql = "" +
                "SELECT " +
                "   e.id AS e_id, e.name AS e_name " +
                "FROM expertise e " +
                "WHERE e.id = ?";

        Expertise expertise = null;

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                expertise = new ExpertiseMapper().readFromResultSet("e", rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expertise;
    }

    @Override
    public List<Expertise> list() {
        String sql = "" +
                "SELECT " +
                "   e.id AS e_id, e.name AS e_name " +
                "FROM expertise e ";

        List<Expertise> expertiseList = new ArrayList<>();

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Expertise expertise = new ExpertiseMapper().readFromResultSet("e", rs);

                expertiseList.add(expertise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expertiseList;
    }

    @Override
    public Expertise save(Expertise expertise) {
        if(!expertise.isValid()) throw new EntityNotPassedValidation(expertise);

        String sql = "INSERT INTO expertise (name) VALUES (?)";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, expertise.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next()){
                expertise.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expertise;
    }
}
