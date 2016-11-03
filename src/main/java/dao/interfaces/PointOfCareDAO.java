package dao.interfaces;

import model.PointOfCare;

import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public interface PointOfCareDAO {
    PointOfCare find(int id);
    List<PointOfCare> list();
    PointOfCare save(PointOfCare pointOfCare);
}
