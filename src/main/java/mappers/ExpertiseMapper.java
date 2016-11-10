package mappers;

import mappers.interfaces.Mapper;
import model.Expertise;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class ExpertiseMapper implements Mapper<Expertise> {

    @Override
    public Expertise readFromResultSet(String alias, ResultSet rs) throws SQLException {
        Expertise expertise = new Expertise();

        expertise.setId(rs.getInt(alias + "_id"));
        expertise.setName(rs.getString(alias + "_name"));

        return expertise;
    }
}
