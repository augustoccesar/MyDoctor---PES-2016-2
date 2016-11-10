package mappers;

import mappers.interfaces.Mapper;
import model.PointOfCare;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCareMapper implements Mapper<PointOfCare> {

    @Override
    public PointOfCare readFromResultSet(String alias, ResultSet rs) throws SQLException {
        PointOfCare pointOfCare = new PointOfCare();

        pointOfCare.setId(rs.getInt(alias + "_id"));
        pointOfCare.setPhoneDdd(rs.getInt(alias + "_phone_ddd"));
        pointOfCare.setPhoneNumber(rs.getInt(alias + "_phone_number"));
        pointOfCare.setStreet(rs.getString(alias + "_street"));
        pointOfCare.setNumber(rs.getInt(alias + "_number"));
        pointOfCare.setDistrict(rs.getString(alias + "_district"));

        return pointOfCare;
    }
}
