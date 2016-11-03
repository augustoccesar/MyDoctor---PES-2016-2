package dao.interfaces;

import model.Expertise;

import java.util.List;

/**
 * Created by augustoccesar on 11/3/16.
 */
public interface ExpertiseDAO {
    Expertise find(int id);
    List<Expertise> list();
    Expertise save(Expertise expertise);
}
