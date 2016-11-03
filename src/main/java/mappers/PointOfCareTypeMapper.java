package mappers;

import model.PointOfCareType;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCareTypeMapper {
    public static PointOfCareType readFromResultSet(String alias, ResultSet rs) throws SQLException {
        PointOfCareType pointOfCareType = new PointOfCareType();

        pointOfCareType.setId(rs.getInt(alias + "_id"));
        pointOfCareType.setName(rs.getString(alias + "_name"));

        return pointOfCareType;
    }
}
