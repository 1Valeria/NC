package by.nc.shpakovskaya.dao.stuff;

import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.dao.CommonDAO;
import by.nc.shpakovskaya.web.connectionPool.ConnectionPoolSing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 23.11.2016.
 */
public class DoctorDAO implements CommonDAO<Doctor> {
    static final String SQL_QUERY_ADD_DOCTOR = "INSERT INTO doctors (name, surname, issue, education, email, login, password, admit)" +
            " VALUES (?,?,?,?,?,?,?,?)";
    static final String SQL_QUERY_GET_DOCTORS = "SELECT * FROM doctors";
    static final String SQL_QUERY_UPDATE_DOCTORS_YES = "UPDATE doctors SET admit='yes' WHERE id=";
    static final String SQL_QUERY_UPDATE_DOCTORS_NO = "UPDATE doctors SET admit='no' WHERE id=";
    static final String SQL_QUERY_UPDATE_DOCTORS_DEPARTMENT_1 = "UPDATE doctors SET id_department= ";
    static final String SQL_QUERY_UPDATE_DOCTORS_DEPARTMENT_2 = " WHERE id=";

    public void add(Doctor doctor) {
        Connection connection = null;
        try {
            connection = ConnectionPoolSing.retrieve();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cracker", "root", "1234");
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_DOCTOR);
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getSurname());
            preparedStatement.setString(3, doctor.getIssue());
            preparedStatement.setString(4, doctor.getEducation());
            preparedStatement.setString(5, doctor.getEmail());
            preparedStatement.setString(6, doctor.getLogin());
            preparedStatement.setString(7, doctor.getPassword());
            preparedStatement.setString(8, doctor.getAdmit());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add doctor");
            System.out.println(e.getMessage());
        } finally {
            try {
                ConnectionPoolSing.putBack(connection);


            } catch (Exception e) {
                System.out.println("SQL exception occurred during add doctor");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Doctor> get() {
        Connection connection = null;
        try {
            connection = ConnectionPoolSing.retrieve();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement;
        ResultSet resultSet;
        List<Doctor> doctors = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_DOCTORS);
            doctors = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add doctor");
            System.out.println(e.getMessage());

        } finally {

            ConnectionPoolSing.putBack(connection);

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
            doctor.setAdmit(resultSet.getString(9));
            doctors.add(doctor);
        }
        return doctors;
    }

    public void update(boolean flag, int id) {
        Connection connection = null;
        try {
            connection = ConnectionPoolSing.retrieve();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            assert connection != null;
            statement = connection.createStatement();
            if (flag) {
                statement.executeUpdate(SQL_QUERY_UPDATE_DOCTORS_YES + id);
            } else {
                statement.executeUpdate(SQL_QUERY_UPDATE_DOCTORS_NO + id);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during update client");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);

        }
    }

    public void setDepartmentToDB(int doctorIdToAdd, int departmentIdToAdd) {
        Connection connection = null;
        try {
            connection = ConnectionPoolSing.retrieve();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            assert connection != null;
            statement = connection.createStatement();

            statement.executeUpdate(SQL_QUERY_UPDATE_DOCTORS_DEPARTMENT_1 + departmentIdToAdd +
                    SQL_QUERY_UPDATE_DOCTORS_DEPARTMENT_2 + doctorIdToAdd);


        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during update client");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);

        }
    }
}
