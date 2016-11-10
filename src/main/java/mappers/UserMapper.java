package mappers;

import mappers.interfaces.Mapper;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/10/16.
 */
public class UserMapper implements Mapper<User>{

    @Override
    public User readFromResultSet(String alias, ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getInt(alias + "_id"));
        user.setEmail(rs.getString(alias + "_email"));

        return user;
    }
}
