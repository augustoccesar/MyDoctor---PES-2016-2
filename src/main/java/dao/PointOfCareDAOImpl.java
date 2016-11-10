package dao;

import dao.interfaces.PointOfCareDAO;
import database.DatabaseManager;
import exceptions.EntityNotPassedValidation;
import mappers.PointOfCareMapper;
import mappers.PointOfCareTypeMapper;
import model.PointOfCare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        if(!pointOfCare.isValid()) throw new EntityNotPassedValidation(pointOfCare);

        String sql = "INSERT INTO point_of_care (point_of_care_type_id, phone_ddd, phone_number, street, number, district) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pointOfCare.getPointOfCareType().getId());
            stmt.setInt(2, pointOfCare.getPhoneDdd());
            stmt.setInt(3, pointOfCare.getPhoneNumber());
            stmt.setString(4, pointOfCare.getStreet());
            stmt.setInt(5, pointOfCare.getNumber());
            stmt.setString(6, pointOfCare.getDistrict());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next()){
                pointOfCare.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pointOfCare;
    }
}
