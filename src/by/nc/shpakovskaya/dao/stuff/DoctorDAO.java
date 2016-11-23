package by.nc.shpakovskaya.dao.stuff;

import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.dao.CommonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 23.11.2016.
 */
public class DoctorDAO implements CommonDAO<Doctor> {
    static final String SQL_QUERY_ADD_DOCTOR = "INSERT INTO doctors (name, surname, issue, education, email, login, password)"+
            " VALUES (?,?,?,?,?,?,?)";
    static final String SQL_QUERY_GET_DOCTORS = "SELECT * FROM doctors";

    public void add(Doctor doctor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cracker", "root", "1234");
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_DOCTOR);
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getSurname());
            preparedStatement.setString(3, doctor.getIssue());
            preparedStatement.setString(4, doctor.getEducation());
            preparedStatement.setString(5, doctor.getEmail());
            preparedStatement.setString(6, doctor.getLogin());
            preparedStatement.setString(7, doctor.getPassword());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add doctor");
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
                System.out.println("SQL exception occurred during add doctor");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Doctor> get() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Doctor> doctors = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cracker", "root", "1234");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_DOCTORS);
            doctors = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add doctor");
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
                System.out.println("SQL exception occurred during add doctor");

            }
        }
        return doctors;
    }

    @Override
    public List<Doctor> init(ResultSet resultSet) throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        while (resultSet.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(resultSet.getInt(1));
            doctor.setName(resultSet.getString(2));
            doctor.setSurname(resultSet.getString(3));
            doctor.setIssue(resultSet.getString(4));
            doctor.setEducation(resultSet.getString(5));
            doctor.setEmail(resultSet.getString(6));
            doctor.setLogin(resultSet.getString(7));
            doctor.setPassword(resultSet.getString(8));
            doctors.add(doctor);
        }
        return doctors;
    }
}
