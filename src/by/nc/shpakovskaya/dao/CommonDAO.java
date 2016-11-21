package by.nc.shpakovskaya.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Valeria on 21.11.2016.
 */
public interface CommonDAO<T extends Entity> {
    void add(T entity);
    List<T> get() throws SQLException;
    List<T> init(ResultSet resultSet) throws SQLException;
}
