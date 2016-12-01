package by.nc.shpakovskaya.dao.hospital;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.dao.CommonDAO;
import by.nc.shpakovskaya.web.connectionPool.ConnectionPoolSing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 21.11.2016.
 */
public class HospitalDAO implements CommonDAO<Hospital> {
    static final String SQL_QUERY_ADD_HOSPITALS = "INSERT INTO hospitals (name)"+
            " VALUES (?)";
    static final String SQL_QUERY_GET_HOSPITALS = "SELECT * FROM hospitals";

    public void add(Hospital hospital) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_HOSPITALS);
            preparedStatement.setString(1, hospital.getName());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add hospital");
            System.out.println(e.getMessage());
        } finally {
            ConnectionPoolSing.putBack(connection);
        }
    }

    @Override
    public List<Hospital> get() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Hospital> hospitals = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_HOSPITALS);
            hospitals = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add hospital");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);
        }
        return hospitals;
    }

    @Override
    public List<Hospital> init(ResultSet resultSet) throws SQLException {
        List<Hospital> hospitals = new ArrayList<>();
        while (resultSet.next()) {
            Hospital hospital = new Hospital();
            hospital.setId(resultSet.getInt(1));
            hospital.setName(resultSet.getString(2));
            hospitals.add(hospital);
        }
        return hospitals;
    }
}
