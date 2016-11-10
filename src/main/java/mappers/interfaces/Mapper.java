package mappers.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 11/10/16.
 */
public interface Mapper<T> {
    T readFromResultSet(String alias, ResultSet rs) throws SQLException;
}
