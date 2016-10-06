package dao;

import dao.interfaces.UserDAO;
import database.DatabaseManager;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl() {
        this.connection = DatabaseManager.getConnection();
    }

    @Override
    public User login(String email, String encryptedPassword) {
        // TODO Add the joins to the query if necessary with the data from doctor and patient
        User user = null;
        String sql = "SELECT " +
                " u.id AS u_id, u.email AS u_email" +
                " FROM users u " +
                " WHERE email = ? " +
                " AND encrypted_password = ? ";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.setString(2, encryptedPassword);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    user = new User();
                    user.setId(rs.getInt("u_id"));
                    user.setEmail(rs.getString("u_email"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User register(User user) {
        // TODO implement
        return null;
    }
}
