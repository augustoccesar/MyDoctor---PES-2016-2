package dao.interfaces;

import model.User;

/**
 * Created by augustoccesar on 10/6/16.
 */
public interface UserDAO {
    User login(String email, String encryptedPassword);
    User register(User user);
}
