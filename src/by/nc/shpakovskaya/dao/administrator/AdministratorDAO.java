package by.nc.shpakovskaya.dao.administrator;

import by.nc.shpakovskaya.beans.roles.administrator.Administrator;
import by.nc.shpakovskaya.dao.CommonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 18.11.2016.
 */
public class AdministratorDAO implements CommonDAO<Administrator> {

    public static final String SQL_QUERY_ADD_ADMINISTRATORS = "INSERT INTO administrators (name, surname, email, login, password)"+
            " VALUES (?,?,?,?,?)";
    public static final String SQL_QUERY_GET_ADMINISTRATORS = "SELECT * FROM administrators";

    public void add(Administrator administrator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cracker", "root", "1234");
            preparedStatement = connection
                    .prepareStatement(SQL_QUERY_ADD_ADMINISTRATORS);
            preparedStatement.setString(1, administrator.getName());
            preparedStatement.setString(2, administrator.getSurname());
            preparedStatement.setString(3, administrator.getEmail());
            preparedStatement.setString(4, administrator.getLogin());
            preparedStatement.setString(5, administrator.getPassword());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add administrator");
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
                System.out.println("SQL exception occurred during add administrator");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Administrator> get() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Administrator> administrators = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cracker", "root", "1234");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_ADMINISTRATORS);
            administrators = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add administrator");
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
                System.out.println("SQL exception occurred during add administrator");

            }
        }
        return administrators;
    }

    public List<Administrator> init(ResultSet resultSet) throws SQLException {
        List<Administrator> administrators = new ArrayList<>();
        while (resultSet.next()) {
            Administrator administrator = new Administrator();
            administrator.setId(resultSet.getInt(1));
            administrator.setName(resultSet.getString(2));
            administrator.setSurname(resultSet.getString(3));
            administrator.setEmail(resultSet.getString(4));
            administrator.setLogin(resultSet.getString(5));
            administrator.setPassword(resultSet.getString(6));
            administrators.add(administrator);
        }
        return administrators;
    }

}
