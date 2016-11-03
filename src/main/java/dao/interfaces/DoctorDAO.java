package dao.interfaces;

import model.Doctor;

import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public interface DoctorDAO {
    Doctor find(int id);
    List<Doctor> listDoctors();
    Doctor save(Doctor doctor);
}
