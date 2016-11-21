package by.nc.shpakovskaya.dao.hospital;

import by.nc.shpakovskaya.beans.departments.Department;
import by.nc.shpakovskaya.dao.CommonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 21.11.2016.
 */
public class DepartmentDAO implements CommonDAO<Department> {

    static final String SQL_QUERY_ADD_DEPARTMENTS = "INSERT INTO departments (name)"+
            " VALUES (?)";
    static final String SQL_QUERY_GET_DEPARTMENTS = "SELECT * FROM departments";

    public void add(Department department) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cracker", "root", "1234");
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_DEPARTMENTS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add department");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL exception occurred during add department");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Department> get() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Department> departments = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cracker", "root", "1234");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_DEPARTMENTS);
            departments = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add department");
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL exception occurred during add department");

            }
        }
        return departments;
    }

    @Override
    public List<Department> init(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
        }
        return departments;
    }
}
