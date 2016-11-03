package dao;

import dao.interfaces.PointOfCareDAO;
import database.DatabaseManager;
import mappers.PointOfCareMapper;
import mappers.PointOfCareTypeMapper;
import model.PointOfCare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCareDAOImpl implements PointOfCareDAO {
    @Override
    public PointOfCare find(int id) {
        String sql = "" +
                "SELECT " +
                "   poc.id AS poc_id, poc.phone_ddd AS poc_phone_ddd, poc.phone_number AS poc_phone_number, poc.street AS poc_street, poc.number AS poc_number, poc.district AS poc_district, " +
                "   poct.id AS poct_id, poct.name AS poct_name " +
                "FROM point_of_care poc " +
                "INNER JOIN point_of_care_type poct ON poc.point_of_care_type_id = poct.id " +
                "WHERE poc.id = ? ";

        PointOfCare pointOfCare = null;

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pointOfCare = PointOfCareMapper.readFromResultSet("poc", rs);
                pointOfCare.setPointOfCareType(PointOfCareTypeMapper.readFromResultSet("poct", rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pointOfCare;
    }

    @Override
    public List<PointOfCare> list() {
        String sql = "" +
                "SELECT " +
                "   poc.id AS poc_id, poc.phone_ddd AS poc_phone_ddd, poc.phone_number AS poc_phone_number, poc.street AS poc_street, poc.number AS poc_number, poc.district AS poc_district, " +
                "   poct.id AS poct_id, poct.name AS poct_name " +
                "FROM point_of_care poc " +
                "INNER JOIN point_of_care_type poct ON poc.point_of_care_type_id = poct.id ";

        List<PointOfCare> pointOfCareList = new ArrayList<>();

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PointOfCare pointOfCare = PointOfCareMapper.readFromResultSet("poc", rs);
                pointOfCare.setPointOfCareType(PointOfCareTypeMapper.readFromResultSet("poct", rs));

                pointOfCareList.add(pointOfCare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pointOfCareList;
    }

    @Override
    public PointOfCare save(PointOfCare pointOfCare) {
        // TODO Implement
        return null;
    }
}
